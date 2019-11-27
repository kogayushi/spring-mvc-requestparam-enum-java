package sample;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

class CustomStringToEnumConverterFactory implements ConverterFactory<String, EnumBase> {
    @Override // 1. `StringToEnumConverterFactory`では`<T extends Enum>`となっているが、`EnumBase`を継承したクラスをGenericsに指定する
    public <T extends EnumBase> Converter<String, T> getConverter(Class<T> targetType) {
        return new CustomStringToEnumConverter(targetType);
    }

    // 2. `StringToEnumConverter`では`<T extends Enum>`となっているが、ここも`EnumBase`を継承したクラスをGenericsに指定する
    private static class CustomStringToEnumConverter<T extends EnumBase> implements Converter<String, T> {
        private Class<T> enumType;

        CustomStringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return EnumBase.of(enumType, source.trim());
        }
    }
}
