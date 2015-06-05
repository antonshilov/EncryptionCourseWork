package encrypt.encrypter;

public interface IEncyptor {
    //Возварщает null если ошибка
    String encrypt(String text);

    String decrypt(String text);
}
