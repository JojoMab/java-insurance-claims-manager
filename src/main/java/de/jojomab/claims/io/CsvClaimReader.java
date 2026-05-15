package de.jojomab.claims.io;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.model.ClaimType;
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

        for (int index = 1; index < lines.size(); index++) {
            if (lines.get(index).isBlank()) {
                continue;
            }
            String[] columns = lines.get(index).split(",");
            claims.add(new Claim(
                    columns[0].trim(),
                    columns[1].trim(),
                    ClaimType.valueOf(columns[2].trim().toUpperCase()),
                    Double.parseDouble(columns[3].trim()),
                    LocalDate.parse(columns[4].trim()),
                    ClaimStatus.valueOf(columns[5].trim().toUpperCase()),
                    0
            ));
        }

        return claims;
    }
}
