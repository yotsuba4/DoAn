package cdio4.cots.foodoffer.constance;

import com.android.volley.toolbox.StringRequest;

public interface JSONKEY {
    final String JSON_STATUS = "status";
    final String JSON_SUCCESS = "success";
    final String JSON_FAILED = "failed";
    final String JSON_DATA = "data";
    final String JSON_TOKEN = "token";
    final String JSON_ERROR = "error";


    //User Object
    final String USERNAME = "username";
    final String PASSWORD = "password";
    final String NEW_PASSWORD = "newPassword";
    final String US_IMAGE = "";
    final String US_FULLNAME = "fullName";
    final String US_GENDER = "gioiTinh";
    final String US_BDATE = "ngaySinh";
    final String US_ID = "CMND";
    final String US_PHONE = "SDT";
    final String US_EMAIL = "email";
    final String US_ADRESS = "diaChi";
    final String TOKEN = "Authorization";
    final String HOST_TOKEN = "Bearer ";

    // Food Object

    // Restaurant Object
}
/*

    cập nhật tài khoản
    url : https://doan5.herokuapp.com/api/user/auth/update
    method: POST
    header token id
    {
        email: '',
                SDT: '',
            diaChi: '',
            fullName: '',
            gioiTinh: true/false,
            ngaySinh: '',
            CMND: '',
    }

    đổi mk:
    url : https://doan5.herokuapp.com/api/user/auth/updatePassword
    method: POST
    header token id
    {
        password: '',
                newPassword: '',
    }

    Lấy thông tin người dùng
    url : https://doan5.herokuapp.com/api/user/auth/getMe
    method: GET

    Kiểm tra tên đăng nhập
    url: https://doan5.herokuapp.com/api/user/auth/verifyUsername?username= + username
    method: GET

    Lấy danh sách nhà hàng - quán ăn
    url: https://doan5.herokuapp.com/api/restaurant
    method: GET

    Lấy danh sách món ăn
1 -> 2 ... tùy m 1 là 20 món ăn đầu tiên
    url: https://doan5.herokuapp.com/food?q=1
    method: GET

    Lấy danh sách hóa đơn -> đang xử lý, đã xác nhận
    url: https://doan5.herokuapp.com/api/user/bill
    method: GET


    Lấy danh sách hóa đơn -> đã thanh toán, đã hủy -> lịch sử hóa đơn
    url: https://doan5.herokuapp.com/api/user/bill/completed
    method: GET

    Xem chi tiết hóa đơn
    url: https://doan5.herokuapp.com/api/user/bill/ + billId
    method: GET

    Xem giỏ hàng
    url: https://doan5.herokuapp.com/api/user/cart/getAll
    method: GET
//
}
*/