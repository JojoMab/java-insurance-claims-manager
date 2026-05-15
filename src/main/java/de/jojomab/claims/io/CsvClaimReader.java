package de.jojomab.claims.io;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimStatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvClaimReader {
    public List<Claim> read(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Claim> claims = new ArrayList<>();
        for (int index = 1; index < lines.size(); index++) {
            String[] columns = lines.get(index).split(",");
            claims.add(new Claim(
                columns[0],
                columns[1],
                Double.parseDouble(columns[2]),
                Integer.parseInt(columns[3]),
                ClaimStatus.valueOf(columns[4].trim().toUpperCase())
            ));
        }
        return claims;
    }
}
