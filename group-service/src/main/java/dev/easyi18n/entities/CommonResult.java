package dev.easyi18n.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author meihang
 * @date 2023/5/28 22:20
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
