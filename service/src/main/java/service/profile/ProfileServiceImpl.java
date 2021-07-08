package service.profile;

import dao.profile.ProfileDao;
import dao.user.UserDao;
import model.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exception.BusinessException;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void addProfile(String name, String surname, String login) {
        Profile profile = new Profile(name, surname, userDao.findByUsername(login));
        profileDao.create(profile);
    }

    @Override
    public void modifyProfile(String login, String name, String surname) {
        Profile profile = userDao.findByUsername(login).getProfile();
        if (profile == null) {
            throw new BusinessException("No such profile");
        }
        profile.setName(name);
        profile.setSurname(surname);
        profileDao.update(profile);
    }

    @Override
    public void deleteProfile(String login) {
        Profile profile = userDao.findByUsername(login).getProfile();
        if (profile == null) {
            throw new BusinessException("No such profile");
        }
        profileDao.deleteById(profile.getId());
    }
}
