create database QLHeThong
go 
use QLHeThong
go
create table duongbay(
	maDuongBay int not null identity primary key,
	tenDuongBay nvarchar(100) not null ,
	viTri nvarchar(100) not null ,
	chieuDai nvarchar(100) ,
	chieuRong nvarchar(100),
	trangThai bit default(1),
)
go
create table maybay(
	maMAYBAY int not null identity primary key,
	tenMayBay nvarchar(100) not null unique,
	hangSanXuat nvarchar(100) ,
	kichTHuoc nvarchar(100),
	soGheL1 int not null ,
	soGheL2 int not null ,
	tongGhe int not null,
	trangThai bit default(1),
)
go 
create table chuyenbay(
	maChuyenBay int not null identity primary key,
	maDuongBay int not null,
	maMAYBAY int not null,
	tenChuyenBay nvarchar(100) not null ,
	ngayBay Date not null,
	ghiChu nvarchar(100),
	diemDi nvarchar(100) not null,
	diemDen nvarchar(100) not null,
	gioBay varchar(50),
	trangThai bit default(1),
	FOREIGN KEY (maMAYBAY) REFERENCES maybay(maMAYBAY),
	FOREIGN KEY (maDuongBay) REFERENCES duongbay(maDuongBay),
)

go 
create table khachhang(
	maKhachHang int not null identity primary key,
	tenKhachHang nvarchar(100) not null ,
	soDienThoai varchar(20) not null ,
	diaCHi nvarchar(100) not null ,
	cmnd  varchar(20) not null ,
)
go
create table nhanvien(
	maNhanVien int not null identity primary key,
	anh varchar(50) ,
	tenNhanVien nvarchar(100) not null ,
	soDienThoai varchar(20) not null unique,
	diaCHi nvarchar(100) not null ,
	chucVu bit default(10),
	userName varchar(100) not null unique ,
	passWord varchar(300) not null ,
	trangThai bit default(0),
)

go 
create table thongtinchitietve(
	maThongTin int not null identity primary key,
	maChuyenBay int not null,
	loaiVe bit default(0),
	giaVe float not null ,
	FOREIGN KEY (maChuyenBay) REFERENCES chuyenbay(maChuyenBay),
)
go 
create table hoadonve(
	maHoaDon int not null identity primary key,
	maKhachHang int not null ,
	maChuyenBay int not null,
	maTHongTin int not null ,
	tongTien float ,
	tGLap DateTime default(CURRENT_TIMESTAMP),
	FOREIGN KEY (maKhachHang) REFERENCES khachhang(maKhachHang),
	FOREIGN KEY (maChuyenBay) REFERENCES chuyenbay(maChuyenBay),
	FOREIGN KEY (maTHongTin) REFERENCES thongtinchitietve(maTHongTin),
)

go
create table [Role](
	rid int identity primary key ,
	roleName varchar(100) not null unique,
	status bit default(0)
)
go
create table UserRole(
	urid int identity primary key ,
	maNhanVien int not null,
	rid int not null ,
	FOREIGN KEY (maNhanVien) REFERENCES nhanvien (maNhanVien),
	FOREIGN KEY (rid) REFERENCES [Role] (rid)
)
go
insert into Role(roleName,status) values ('ROLE_ADMIN',1)
insert into nhanvien(tenNhanVien,soDienThoai,diaCHi,userName,passWord) values ('viet anh',01232132323,'ha noi','admin','$12$Yl4VxAljdyO.AvqCfhiHnuoIycGznK7VC0dHa9GHbt4gpI7I672s.')
insert into UserRole(maNhanVien,rid) values (1,1)