package com.next.jiangzh.springboot.nextfilmcinema.dao.mapper;

import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.CinemaFilmInfoVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.CinemaFilmVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.FieldHallInfoVO;
import com.next.jiangzh.springboot.nextfilmcinema.dao.entity.FilmFieldT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    List<CinemaFilmVO> describeFieldList(@Param("cinemaId") String cinemaId);

    CinemaFilmInfoVO describeFilmInfoByFieldId(@Param("fieldId") String fieldId);

    FieldHallInfoVO describeHallInfo(@Param("fieldId") String fieldId);

}
