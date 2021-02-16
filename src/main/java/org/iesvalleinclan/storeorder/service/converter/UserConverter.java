package org.iesvalleinclan.storeorder.service.converter;


import org.iesvalleinclan.storeorder.model.UserVO;
import org.iesvalleinclan.storeorder.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private AddressConverter addressConverter;

    public UserDTO convertEntityToDTO(final UserVO userVO) {

        return UserDTO.builder().email(userVO.getEmail())
                .name(userVO.getName())
                .surname(userVO.getSurname())
                .phone(userVO.getPhone()).build();
    }

    public UserVO convertDTOToEntity(final UserDTO userDTO) {
        return UserVO.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .phone((userDTO.getPhone())).build();
    }
}