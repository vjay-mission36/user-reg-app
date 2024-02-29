package com.mission42.service;

import com.mission42.dto.IPRestAPIResponse;
import com.mission42.dto.UserWelcomeMsgDTO;
import com.mission42.model.User;
import com.mission42.model.UserRegModel;
import com.mission42.repo.UserRegRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class UserRegService {
    private static final String REST_API_IP = "http://ip-api.com/json/";
    private static final String FIELDS = "?fields=status,message,country,countryCode,city";

    private static final String ERROR_WELCOME_MSG = "Username registration not from Canada. ";
    private static final String STR_CANADA = "Canada";
    private static final Logger LOG = LoggerFactory.getLogger(UserRegService.class);
    @Autowired
    private UserRegRepo userRegRepo;

    public UserWelcomeMsgDTO registerUser(UserRegModel userRegModel) {
        String ip = userRegModel.getIp();
        IPRestAPIResponse ipRestAPIResponse = getCountryAndCity(ip);
        LOG.info(ipRestAPIResponse.toString());

        UserWelcomeMsgDTO usrRegWelcomeMsg;

        if (!ipRestAPIResponse.getCountry().equalsIgnoreCase(STR_CANADA)) {
            usrRegWelcomeMsg = new UserWelcomeMsgDTO("ERROR", ERROR_WELCOME_MSG);
        } else {
            User user = User.builder()
                    .id(UUID.randomUUID().toString())
                    .userName(userRegModel.getUserName())
                    .password(userRegModel.getPassword())
                    .build();

            user = userRegRepo.save(user);
            usrRegWelcomeMsg = new UserWelcomeMsgDTO(user.getId(), user.getUserName() + ", Welcome from " + ipRestAPIResponse.getCity());
        }
        return usrRegWelcomeMsg;
    }

    private IPRestAPIResponse getCountryAndCity(String ip) {
        RestTemplate restTemplate = new RestTemplate();
        final IPRestAPIResponse ipRestAPIResponse = restTemplate.getForObject(REST_API_IP + ip + FIELDS, IPRestAPIResponse.class);
        LOG.info(ipRestAPIResponse.getStatus());
        return ipRestAPIResponse;
    }

}
