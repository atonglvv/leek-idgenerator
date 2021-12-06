package cn.atong.leek.idgenerator.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: leek-idgenerator
 * @description: 返回类型
 * @author: atong
 * @create: 2021-04-13 16:22
 */
@Data
public class Result<T> implements Serializable {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    private static final long serialVersionUID = 1L;
    private String status;
    private String msg;
    private Integer code;
    private T data;

    public Result(String status, String msg, Integer code, T data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    /**
     * @description 返回成功, 无消息, 无数据
     * @return cn.atong.leek.idgenerator.response.Result<T>
     * @author atong
     * @date 2021/4/13 17:02
     * @version 1.0.0.1
     */
    public static <T> Result<T> success() {
        return new Result<T>(SUCCESS , "" , ResponseCode.SUCCESS , null);
    }


    /**
     * @description 返回成功, 自定义msg, 无数据
     * @param msg: 消息
     * @return cn.atong.leek.idgenerator.response.Result<T>
     * @author atong
     * @date 2021/4/13 17:04
     * @version 1.0.0.1
     */
    public static <T> Result<T> success(String msg) {
        return new Result<T>(SUCCESS , msg , ResponseCode.SUCCESS , null);
    }

    /**
     * @description 返回成功, 自定义msg, 附加数据
     * @param msg: 消息
     * @param t: 数据
     * @return cn.atong.leek.idgenerator.response.Result<T>
     * @author atong
     * @date 2021/4/13 17:10
     * @version 1.0.0.1
     */
    public static <T> Result<T> success(String msg, T t) {
        return new Result<T>(SUCCESS , msg , ResponseCode.SUCCESS , t);
    }


    /**
     * @description 返回错误, 附加消息 与 ResponseCode 与 数据
     * @param msg: 消息
     * @param code: ResponseCode
     * @param t: data
     * @return cn.atong.leek.idgenerator.response.Result<T>
     * @author atong
     * @date 2021/4/13 17:12
     * @version 1.0.0.1
     */
    public static <T> Result<T> error(String msg , Integer code , T t) {
        return new Result<T>(ERROR , msg , code , t);
    }

    public static <T> Result<T> error(String msg , Integer code) {
        return new Result<T>(ERROR , msg , code , null);
    }


    public boolean isSuccess() {
        return SUCCESS.equals(status);
    }

}
