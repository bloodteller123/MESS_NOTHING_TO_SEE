package com.manager.app.service.serviceImpl;

import com.manager.app.mapper.UserMapper;
import com.manager.app.model.User;
import com.manager.app.repository.UserRepository;
import com.manager.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public int delete(List<User> users) {
        return 0;
    }

    @Override
    public User findUserById(Long id) {
        if(id==null) return null;
        log.info("id not null");
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void insertUser(User record) {
//        User user = User.builder()
//                .name(userInsertionRequest.name())
//                .email(userInsertionRequest.email())
//                .mobile(userInsertionRequest.mobile())
//                .password(userInsertionRequest.password())
//                .status(userInsertionRequest.status())
//                .build();
//
//        this.userRepository.save(user);
        if(record.getId() == null || record.getId() == 0){
            //new
            log.info("new User");
            userRepository.save(record);
        } else{
            log.info("update old User");
            Optional<User> userOptional = userRepository.findById(record.getId());
            if(userOptional.isPresent()){
                User user = userOptional.get();
//                partial updates
                userMapper.updateUserFrom(record, user);
                userRepository.save(user);
            }
        }

    }

    @Override
    public boolean deleteUserById(Long id) {
        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
