package sample;

import java.util.Arrays;

public interface EnumBase<E extends Enum<E>> { // 1. GenericsでEnumを指定することで、Enumにしか継承させないようにする
                                               // 同僚に教えてもらったが、再起的ジェネリクスという名前がついているらしいです。
                                               // よくわかってないので間違っていれば指摘お願いします🙇‍♂️

    // 2. コード値を使うので、そのgetterを生やしておく
    String getCode();

    // 3. `<E extends EnumBase> E`のGenericsでinput/outputの型が同じだと宣言する
    public static <E extends EnumBase> E of(Class<E> enumClass, String code) {
        return Arrays.stream(enumClass.getEnumConstants()) // 4. (3)によって`enumClass`はEnumであると仮定できるはずなので、`getEnumConstants()`で定義されているものをすべて取得してstreamに変換
                     .filter(it -> it.getCode().equals(code)) // 6. 引数の`code`と一致するものを検索
                     .findFirst() // 7. 1件のみ該当するはずなので最初に一致したものを選択
                     // 8. 該当するものがなかった場合、コーディングバグなのでExceptionを飛ばしてFWまで貫通させてシステムエラーにする
                     // もし、このハンドリングでは問題がある場合は`null`を返して、クライアントコードにハンドリングさせる
                     .orElseThrow(() -> new IllegalArgumentException(String.format("%s does not have such code => [%s]",
                                                                                   enumClass.getSimpleName(),
                                                                                   code)));
    }
}
