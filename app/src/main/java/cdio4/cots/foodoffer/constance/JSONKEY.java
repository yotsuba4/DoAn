package cdio4.cots.foodoffer.constance;

import com.android.volley.toolbox.StringRequest;

public interface JSONKEY {
    final String JSON_STATUS = "status";
    final String JSON_SUCCESS = "success";
    final String JSON_FAILED = "failed";
    final String JSON_DATA = "data";
    final String JSON_TOKEN = "token";
    final String JSON_ERROR = "error";
    final String JSON_MENU = "menu";

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
    final String FOOD_ARR = "foods";
    final String FOOD_NAME = "tenMon";
    final String FOOD_PRICE = "gia";
    final String FOOD_IMAGE = "hinhAnh";

    // Function search
    final String KEY_SEARCH_TYPE1 = "name";

    // Restaurant Object
    final String RESTAURANT = "restaurant";
    final String MENU = "menu";
    final String LOACTION = "toaDo";
    final String X = "x";
    final String Y = "y";
    final String RESTAURANT_NAME = "tenNhaHang";
    final String RESTAURANT_IMAGE = "hinh";
    final String RESTAURANT_EMAIL = "email";
    final String RESTAURANT_ADRESS = "diaChi";
    final String RESTAURANT_PHONE = "SDT";
    final String RESTAURANT_STYPE = "loaiHinh";
    final String RESTAURANT_STYPE_NAME = "name";

    // Bill Object

    final String BILL = "bill";
    final String BILL_ID = "_id";
    final String CUS_ID = "khachHang";
    final String RES_ID = "nhaHang";
    final String BILL_DATE_TIME = "dateCreate";
    final String BILL_STATUS = "isCompleted";
    final String BILL_TOTAL = "total";
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