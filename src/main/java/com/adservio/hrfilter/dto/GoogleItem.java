package com.adservio.hrfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class GoogleItem {
    private String kind;
    private String fileExtension;
    private String md5Checksum;
    private String selfLink;
    private List<String> ownerNames;
    private String lastModifyingUserName;
}
