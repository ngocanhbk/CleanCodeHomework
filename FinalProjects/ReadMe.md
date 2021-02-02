# Bùi Thị Ngọc Anh
## Khoá học Clean Code - Luvina 2020


## Phần 1: Clean Code căn bản
1. 5 mục tiêu chính của Clean Code là
   - Mục tiêu 1: Source Code phải thanh lịch: "thanh lịch" - phải sạch sẽ, cảm thấy hứng thú khi đọc
   - Mục tiêu 2: Code đúng trọng tâm : Mỗi fucntion, mỗi class, mỗi module chỉ thực hiện một chức năng duy nhất, không bị phân tán, bởi các context xung quanh
   - Mục tiêu 3: Tối ưu số lượng các class, method, function ...
   - Mục tiêu 4: Code đơn giản, có trật tự và dễ bảo trì
   - Mục tiêu 5: Chạy tốt tất cả các case bình thường
2. Đáp án của tôi là team C bởi vì:
   - Lý do 1: có thể coi việc cleanCode như 1 checklist dự án, làm càng nhiều thì sẽ càng nhớ. Ban đầu sẽ chỉ áp dụng những quy tắc dễ, dẫn dần sẽ áp dụng tiếp những quy tắc khó hơn.
   - Lý do 2: cleancode sớm thì những người tiếp nhận sau đó sẽ dễ dàng hơn
3. Hãy nhìn nhận xa hơn đến việc phải bảo trì code trong tương lai.
- Nếu không cleanCode, có thể có bug tiềm ẩn mà coder có thể khó phát hiện được
- Giả sử bạn code 1 đoạn code chỉ trong 10p, tuy nhiên người tiếp nhận đoạn code đấy của bạn mất tận 1 giờ để có thể hiểu bạn code gì,
vậy việc bạn bỏ ra 30p để trau chuốt đoạn code trên và người tiếp nhận chỉ đọc 1 lần là hiểu, cách nào tốn công số hơn.
4.Đề xuất của Bob và Vân là phù hợp, tuy nhiên mỗi đề xuất có các lỗi riêng.
- Đề xuất của Bob: int calculateSalaryAfterYears(int years, float raise);
==> có thể sử dụng float raise là thuộc tính trong class Salary.
- Đề xuất của Vân: int calculateSalaryAfterYears(int initialSalary, int NthYear);
==> biến NthYear đặt tên khó hiểu, "Nth" là gì??
5.

## Phần 2: OOP và SOLID
### 1. Hãy lập trình Java để thực hiện thiết kế như hình vẽ
[Link source BT phần 2](https://github.com/ngocanhbk/CleanCodeHomework/tree/master/FinalProjects/Phan%202)

### 2. Composition over Inheritance và DI

## Phần 3: Thiết kế CSDL Quan hệ theo đặc tả
[Link source BT phần 3](https://github.com/ngocanhbk/CleanCodeHomework/tree/master/FinalProjects/Phan%203)

## Phần 4: Thiết kế RESTful API
[Link source BT phần 4](https://github.com/ngocanhbk/CleanCodeHomework/tree/master/FinalProjects/Phan%204/Excercise4)

## Phần 5: Lập trình Restful API
[Link source BT phần 5](https://github.com/ngocanhbk/CleanCodeHomework/tree/master/FinalProjects/Phan%205/Excercise5)

## Trắc nghiệm
1.C		2.B		3.D		4.C		5.A	
6.B		7.B		8.A		9.B		10.A	
11.D	12.C	13.B	14.D	15.D	
16.B	17.D	18.A	19.C	20.B	
21.B	22.		23.B	24.A	25.	
