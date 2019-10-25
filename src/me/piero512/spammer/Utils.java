package me.piero512.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class Utils {
    static List<String> getCorreos(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.lines()
                .map((String::trim))
                .filter((s -> s.length() > 0))
                .collect(Collectors.toList());
    }
}
