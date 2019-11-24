package sample;

import java.util.Arrays;

public interface EnumBase<E extends Enum<E>> {

    String getCode();

    public static <E extends EnumBase> E of(Class<E> enumClass, String code) {
        return Arrays.stream(enumClass.getEnumConstants())
                     .filter(it -> it.getCode().equals(code))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(String.format("%s does not have such code => [%s]",
                                                                                   enumClass.getSimpleName(),
                                                                                   code)));
    }
}
