package com.myfruit.pms.mapper;

import com.myfruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    // Optional : 데이터 null 값인 것 방지
    Optional<ItemDto> getItemById(int id);

    //  ItemDto insertItem(ItemDto itemDto);  // PK 가 생성되었을 때 참조 주소 반환
    //  int insertItem(ItemDto itemDto);  // PK 가 생성되었을 때 int 는 성공 or 실패 여부
    void insertItem(ItemDto itemDto);
    List<ItemDto> getItems();
    void updateItem(ItemDto itemDto);
    void deleteItem(int id);


}
