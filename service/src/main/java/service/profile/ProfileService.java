package service.profile;

public interface ProfileService {

    void addProfile(String name, String surname, String login);

    void modifyProfile(String login, String name, String surname);

    void deleteProfile(String login);
}
