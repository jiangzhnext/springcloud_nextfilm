package com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandResVO implements Serializable {

    private String brandId;
    private String brandName;
    private String isActive;

}
