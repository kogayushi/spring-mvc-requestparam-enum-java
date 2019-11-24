package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/alt-js")
@RestController
public class AltJsResource {

    @GetMapping
    public List<String> list() {
        return Arrays.stream(AltJs.values())
                     .map(AltJs::getGenericName)
                     .collect(Collectors.toList());
    }

    @GetMapping("/genericName")
    public String answer(@RequestParam(name = "code") AltJs altJs) {
        return altJs.getGenericName();
    }
}
