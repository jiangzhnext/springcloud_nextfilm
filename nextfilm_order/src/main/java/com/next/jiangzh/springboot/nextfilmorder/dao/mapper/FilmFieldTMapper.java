package com.next.jiangzh.springboot.nextfilmorder.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.next.jiangzh.springboot.nextfilmorder.controller.cinema.vo.CinemaFilmInfoVO;
import com.next.jiangzh.springboot.nextfilmorder.dao.entity.FilmFieldT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2019-04-06
 */
public interface FilmFieldTMapper extends BaseMapper<FilmFieldT> {

    CinemaFilmInfoVO describeFilmInfoByFieldId(@Param("fieldId") String fieldId);

}
