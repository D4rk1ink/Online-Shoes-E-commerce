# Online-Shoes-E-commerce

<b>ความสามารถของระบบ</b><br />
<br />
1.หน้า Dashboard สาหรับ Admin<br />
สามารถ Login / Logout ได้<br />
สามารถจัดการสินค้าได้<br />
สามารถเพิ่มสินค้าได้<br />
สามารถดูของมูลการสั่งสินค้าของ User ได้<br />
สามารถแก้ไขสถานะ การสั่งซื้อได้<br />
<br />
2.หน้าเว็บส่วนของข้อมูลสินค้า (User ทั่วไปที่ไม่ได้เข้าสู่ระบบ)<br />
สามารถดูรายละเอียดสินค้าได้<br />
สามารถค้นหาสินค้าได้<br />
<br />
3.หน้าเว็บส่วนของข้อมูลสินค้าและหน้าการสั่งซื้อสินค้า (User ที่เป็นสมาชิก)<br />
สามารถ Login / Logout ได้<br />
สามารถดูรายละเอียดสินค้าได้<br />
สามารถค้นหาสินค้าได้<br />
สามารถเพิ่มสินค้าลงตะกร้าสินค้าได้<br />
สามารถสั่งสินค้าและชาระเงินได้ทันที (ตัดเงินผ่านระบบ Omise)<br />

<b>ตั้งค่าการติดต่อ Database</b>

แก้ไขค่าต่างๆ ในไฟล์ MyServletContext.java<br />

-host name<br />
-port<br />
-database name<br />
-database username<br />
-database password<br />

<b>Set Omise Key</b><br />
file : servlet/login.java<br />
'''
listsession.add(new ShoppingCart("public_key_omise"));
'''
