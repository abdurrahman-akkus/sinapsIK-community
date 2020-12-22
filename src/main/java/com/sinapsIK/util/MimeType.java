/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinapsIK.util;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dijital
 */
public class MimeType {

    public String getExtensionFromMimeType(MultipartFile file) {
        String mimeTypeGuess = "";
        if (file.getOriginalFilename().lastIndexOf(".") > 0) {
            mimeTypeGuess = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        }
        String mimeType = file.getContentType();
        String extension = "";
        switch (mimeType) {
            case "application/pdf":
                extension = ".pdf";
                break;
            case "image/png":
                extension = ".png";
                break;
            case "image/jpeg":
                if (mimeTypeGuess == "jpeg") {
                    extension = ".jpeg";
                } else {
                    extension = ".jpg";
                }
                break;
            case "image/pjpeg":
                if (mimeTypeGuess == "jpeg") {
                    extension = ".jpeg";
                } else {
                    extension = ".jpg";
                }
                break;
        }

        return extension;
    }
}
