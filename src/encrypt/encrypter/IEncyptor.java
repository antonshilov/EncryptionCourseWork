package encrypt.encrypter;

public interface IEncyptor {
    //���������� null ���� ������
    String encrypt(String text);

    String decrypt(String text);
}
