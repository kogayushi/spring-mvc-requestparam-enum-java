package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/jvm-languages")
@RestController
public class JvmLanguageResource {

    @GetMapping
    public List<String> list() {
        return Arrays.stream(JvmLanguage.values())
                     .map(JvmLanguage::getGenericName)
                     .collect(Collectors.toList());
    }

    @GetMapping("/genericName")
    public String answer(@RequestParam(name = "code") JvmLanguage jvmLanguage) {
        return jvmLanguage.getGenericName();
    }
}
