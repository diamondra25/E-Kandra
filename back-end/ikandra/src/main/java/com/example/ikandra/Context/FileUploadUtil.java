package com.example.ikandra.Context;


import java.io.IOException;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static String uploadFile(String uploadDir, Long id_user, MultipartFile file, String designation) {
        String fileUrl = "";
        try {
            Files.createDirectories(Path.of(uploadDir));

            String prefix = (designation != null && !designation.isEmpty()) ? designation + "_" : "";
            String fileName = prefix + id_user + "_" + file.getOriginalFilename();

            Path filePath = Paths.get(uploadDir, fileName);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("Ancien fichier supprimé : " + filePath);
            }

            Files.write(filePath, file.getBytes(), StandardOpenOption.CREATE);

            fileUrl = uploadDir + fileName;
            System.out.println("Fichier uploadé avec succès : " + fileUrl);

        } catch (IOException e) {
            System.err.println("Problème de fichier : " + e.getMessage());
            e.printStackTrace();
        }

        return fileUrl;
    }
}
