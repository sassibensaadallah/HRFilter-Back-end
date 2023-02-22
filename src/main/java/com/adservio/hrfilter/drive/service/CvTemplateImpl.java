package com.adservio.hrfilter.drive.service;

import com.adservio.hrfilter.drive.entity.CvTemplate;
import com.adservio.hrfilter.drive.repository.CVTemplateRepository;
import com.adservio.hrfilter.dto.CvTemplateDTO;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CvTemplateImpl implements ICvTemplateService {
    private CVTemplateRepository cvTemplateRepository;
    private GoogleCredentialService googleCredentialService;
    @Override
    public CvTemplate getOneCvTemplate(Long id) {
        return cvTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Please enter a correct id!"));
    }
    @Override
    public List<CvTemplateDTO> getCvTemplates() throws GeneralSecurityException, IOException {

        Drive myDrive = googleCredentialService.getDrive("credentials.json");
        return cvTemplateRepository.findAll()
                .stream().map(cvTemplate ->{
                    try {
                        Drive.Files.Get file = myDrive.files().get(cvTemplate.getGoogleDriveId());
                        return CvTemplateDTO.builder()
                                .template(cvTemplate.getHtml())
                                .imageName(file.execute().getName())
                                .image(Base64.getEncoder().encodeToString(
                                        file.executeMedia().getContent().readAllBytes()
                                ))
                                .id(cvTemplate.getId())
                                .description(cvTemplate.getDescription())
                                .build();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }}).collect(Collectors.toList());
    }


    @Override
    public CvTemplate addCvTemplate(CvTemplateDTO cvTemplateDTO) throws GeneralSecurityException, IOException {
        Drive myDrive = googleCredentialService.getDrive("credentials.json");
        File myFile = new File();
        myFile.setName(UUID.randomUUID().toString());
        ByteArrayContent byteArrayContent = new ByteArrayContent("[*/*]",cvTemplateDTO.getImage().getBytes());
        Drive.Files.Create create =myDrive.files().create(myFile, byteArrayContent);
        File createdFile = create.execute().clone();
        CvTemplate cvTemplate = new CvTemplate(null, cvTemplateDTO.getTemplate(), cvTemplateDTO.getDescription(), createdFile.getId());
        return cvTemplateRepository.save(cvTemplate);
    }

    @Override
    public CvTemplate updateCvTemplate(CvTemplateDTO cvTemplate) throws GeneralSecurityException, IOException {
        CvTemplate entity = cvTemplateRepository.findById(cvTemplate.getId())
                .orElseThrow(() -> new RuntimeException("Please enter a correct id!"));
        entity.setDescription(cvTemplate.getDescription());
        entity.setHtml(cvTemplate.getTemplate());
        Drive myDrive = googleCredentialService.getDrive("credentials.json");
        File myFile = new File();
        myFile.setName(UUID.randomUUID().toString());
        ByteArrayContent byteArrayContent = new ByteArrayContent("[*/*]",cvTemplate.getImage().getBytes());
        Drive.Files.Update update =myDrive.files().update(entity.getGoogleDriveId(), myFile, byteArrayContent);
        File createdFile = update.execute().clone();
        return cvTemplateRepository.save(
                new CvTemplate(cvTemplate.getId(), cvTemplate.getTemplate(), cvTemplate.getDescription(), createdFile.getId())
        );

    }

    @Override
    public void deleteCvTemplate(Long id) throws GeneralSecurityException, IOException {
        CvTemplate entity = cvTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Please enter a correct id!"));
        Drive myDrive = googleCredentialService.getDrive("credentials.json");
        File myFile = new File();
        myFile.setName(UUID.randomUUID().toString());
        myDrive.files().delete(entity.getGoogleDriveId());
        cvTemplateRepository.deleteById(id);
    }
}
