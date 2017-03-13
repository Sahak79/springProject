package am.gch.usd.common.data.model.converter;

import am.gch.usd.common.data.model.lcp.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserStatus status) {
        return status.getValue();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer value) {
        return UserStatus.valueOf(value);
    }
}

