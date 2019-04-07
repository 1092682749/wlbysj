package com.rain.dao;

import com.rain.domain.PersonalInfo;
import com.rain.domain.PersonalInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalInfoMapper {
    long countByExample(PersonalInfoExample example);

    int deleteByExample(PersonalInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonalInfo record);

    int insertSelective(PersonalInfo record);

    List<PersonalInfo> selectByExample(PersonalInfoExample example);

    PersonalInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonalInfo record, @Param("example") PersonalInfoExample example);

    int updateByExample(@Param("record") PersonalInfo record, @Param("example") PersonalInfoExample example);

    int updateByPrimaryKeySelective(PersonalInfo record);

    int updateByPrimaryKey(PersonalInfo record);

    PersonalInfo findById(Integer id);
}