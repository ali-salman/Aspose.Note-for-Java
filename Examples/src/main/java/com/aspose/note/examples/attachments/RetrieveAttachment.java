package com.aspose.note.examples.attachments;

import com.aspose.note.AttachedFile;
import com.aspose.note.Document;
import com.aspose.note.examples.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class RetrieveAttachment {
    public static void main(String... args)
            throws IOException {

        String inputFile = "Sample1.one";
        Path inputPath = Utils.getPath(RetrieveAttachment.class, inputFile);

        // Load the document into Aspose.Note
        Document doc = new Document(inputPath.toString());

        // Get list of attachments
        List<AttachedFile> attachments = doc.getChildNodes(AttachedFile.class);
        System.out.println("Total attachments: " + attachments.size());

        for (AttachedFile a : attachments) {
            // Load attachment into memory
            byte[] buffer = a.getBytes();
            ByteArrayInputStream stream = new ByteArrayInputStream(buffer);

            // Save it to output location
            String outputFile = "Output_" + a.getFileName();
            Path outputPath = Utils.getPath(RetrieveAttachment.class, outputFile);
            Files.copy(stream, outputPath, StandardCopyOption.REPLACE_EXISTING);

            // :)
            System.out.println("File saved: " + outputPath);
        }
    }
}

