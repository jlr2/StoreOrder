package org.iesvalleinclan.storeorder.service.converter;

import org.iesvalleinclan.storeorder.model.AddressVO;
import org.iesvalleinclan.storeorder.model.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    public AddressDTO convertEntityToDTO(final AddressVO addressVO) {

        return AddressDTO.builder().city(addressVO.getCity()).address(addressVO.getAddress())
                .zipCode(addressVO.getZipCode()).build();
    }

    public AddressVO convertDTOToEntity(final AddressDTO addressDTO) {

        return AddressVO.builder().city(addressDTO.getCity())
                .address(addressDTO.getAddress())
                .zipCode(addressDTO.getZipCode()).build();
    }
}

