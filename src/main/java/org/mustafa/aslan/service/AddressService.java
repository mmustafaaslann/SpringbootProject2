package org.mustafa.aslan.service;

import org.mustafa.aslan.dto.AddressDto;
import org.mustafa.aslan.dto.UserDto;
import org.mustafa.aslan.entity.Address;
import org.mustafa.aslan.entity.User;
import org.mustafa.aslan.repository.AddressRepository;
import org.mustafa.aslan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> getAddresses(){
        return addressRepository.findAll()
                .stream()
                .map(address -> {
                    return new AddressDto(
                            address.getUserId(),
                            address.getStreet(),
                            address.getNumber(),
                            address.getPostCode()
                    );
                }).collect(Collectors.toList());
    }


    public void deleteAddress(Long addressId) {
        boolean exists = addressRepository.existsById(addressId);
        if (!exists)
            throw new IllegalStateException("Address with id " + addressId + " does not exiest");
        addressRepository.deleteById(addressId);
    }

    @Transactional
    public void updateAddress(Address addressToUpdate) {
        Optional<Address> address = addressRepository.findById(addressToUpdate.getId());
        if (address.isPresent()) {
            if (address.get().getStreet() != null && address.get().getStreet().length() > 0) {
                address.get().setStreet(addressToUpdate.getStreet());
            }
            if (address.get().getNumber()>0) {
                address.get().setNumber(addressToUpdate.getNumber());
            }
            if (address.get().getPostCode() > 0) {
                address.get().setPostCode(addressToUpdate.getPostCode());
            }
        }
    }

}
