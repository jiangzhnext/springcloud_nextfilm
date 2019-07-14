package com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallTypeResVO implements Serializable {

    private String halltypeId;
    private String halltypeName;
    private String isActive;

}
