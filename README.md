A screenshot of printAll(...) .

![image](https://github.com/user-attachments/assets/7dc3833f-02cc-41f1-a475-4f082e489b92)

A screenshot of printAllUsers(...) and their remaining balance .

![image](https://github.com/user-attachments/assets/796f07c8-798f-4a5d-aa8c-6bb222675d38)


1/ it's not the recommended approach because it leads to tight coupling and also violates SOLID princples , specifically single responsibility and open/closed principles.

2/ another way would be to allow updating room data directly, even if bookings exist. However, this can cause inconsistencies,
   like changing the price or type after a booking was made. The current approach is better because it preserves booking history and ensures data integrity.

