public class ShippingService {
    public String generateWaybill(Customer cust) {
        if( cust == null){
            System.out.print("Thiếu thông tin người dùng");
            return null;
        }else if(cust.getAddress().isblank() ){
            System.out.print("Thiếu địa chỉ người dùng");
            return null;
        }
        String s="Vẫn chuyển đơn tới "+cust.getAddress().getCity();
    }
}
