package com.example.claims.io;

import com.example.claims.model.Claim;
import com.example.claims.util.ClaimValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvClaimReader {
    public List<Claim> read(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Claim> claims = new ArrayList<>();
        ClaimValidator validator = new ClaimValidator();
        for (int index = 1; index < lines.size(); index++) {
            String[] columns = lines.get(index).split(",");
            Claim claim = new Claim(
                columns[0],
                columns[1],
                Claim.ClaimType.valueOf(columns[2]),
                Double.parseDouble(columns[3]),
                LocalDate.parse(columns[4]),
                Claim.ClaimStatus.valueOf(columns[5])
            );
            if (!validator.isValid(claim)) {
                throw new IllegalArgumentException("Ungültiger Schadensfall in Zeile " + (index + 1));
            }
            claims.add(claim);
        }
        return claims;
    }
}
