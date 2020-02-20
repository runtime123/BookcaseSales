数据库：BookcaseSalesDB
    /*创建图书类型信息表表，按内容划分图书大类*/
    create table book_type(
         book_type_id int primary key not null comment '图书类型编号',
         book_type_name varchar(20) not null comment '图书类型名称'
    ) comment '图书类型表';

    insert into book_type(book_type_id, book_type_name)
    values(1,'马列毛经典著作'),(2,'哲学'),(3,'社会科学'),(4,'自然科学'),(5,'综合类图书');
    select book_type_id, book_type_name from book_type;

    /*创建图书类型详细信息表，将大类或分为更详细的小类*/
    create table book_type_detail(
        detail_id int primary key not null comment '详细图书类型编号',
        book_type_id int not null comment '图书类型编号',
        detail_type_name varchar(8) not null comment '详细图书类型名称'
    ) comment '图书类型详细星信息表';

    insert into book_type_detail(detail_id, book_type_id, detail_type_name)
    values (1,1,'马克思主义'),(2,1,'列宁主义'),(3,1,'邓小平理论'),(4,1,'毛泽东思想'),
            (6,2,'哲学'),(7,2,'宗教'),
           (8,3,'文化'),(9,3,'军事'),(10,3,'经济'),(11,3,'文学'),
           (12,4,'数理化'),(13,4,'天文地理'),(14,4,'生物医学'),(15,4,'农业工业'),
            (16,5,'玄幻'),(17,5,'仙侠'),(18,5,'科幻'),(19,5,'都市');

    select * from book_type_detail;

    select * from book_type bt
    inner join book_type_detail btd
    on bt.book_type_id = btd.book_type_id
    where btd.book_type_id =1;


    /*创建图书信息表*/
    create table book(
        book_id int primary key auto_increment not null comment '',
        detail_id int not null comment '图书类型编号',
        book_name varchar(50) not null comment '图书名称',
        book_author varchar(20) not null comment '图书作者',
        book_publisher varchar(20) not null comment '出版社',
        book_publisher_date date not null comment '出版时间',
        book_purchase_price decimal not null comment '进货价',
        book_sell_price decimal not null comment '售价',
        book_discount int not null comment '折扣',
        book_amount int not null comment '库存',
        book_sales int not null comment '销量',
        book_cover varchar(50) not null comment '封面路径',
        book_introduce varchar(500) comment '图书简介'
    ) comment '图书信息表';

    select * from book b
    inner join book_type_detail btd
    on b.detail_id = btd.detail_id;

    insert into book(detail_id, book_name, book_author, book_publisher, book_publisher_date, book_purchase_price, book_sell_price, book_discount, book_amount, book_sales, book_cover, book_introduce)
    values
    (2,'《列宁主义》','尼尔·哈丁','南京大学出版社','2014-08-12',48.00,480.00,8,100,554,'static/image/列宁主义.jpg','本书是第一部重新全面解读列宁主义的意识形态的著作，是作者多年潜心研究的理论成果。本书既是对列宁主义的一种阐释，也是对当代共产主义政治的重要性的一种批判。'),
    (3,'《邓小平时代》','傅高义','新知三联书店','2000-11-11',100.00,10000.00,10,1000,10000,'static/image/邓小平理论.jpg',' 邓小平深刻影响了中国历史和世界历史的走向，也改变了每一当代中国人的命运。解读邓小平的政治生涯及其行为逻辑，就是解读当代中国，解读个人命运背后的历史变局。'),
    (4,'《毛泽东的读书生活》','龚育知','新知三联书店','2009-7-1',50.00,500.00,10,100,66,'static/image/毛泽东的读书生活.jpg','关于毛泽东的读书生活，有很多故事流传。青年时期，为了锻炼毅力，在街头读书，以求闹中取静；战争时期，生活在最艰苦、最紧张的环境中依然没有放弃读书，书籍是他最宝贵的财富，他对书籍爱护有加。因形势所迫，有时不得不放弃所有书籍，每逢此时，他都十分伤心。他的大部分藏书，特别是他有过批注的书，几经辗转，历尽艰辛，最终搬到了北京。解放后，他将卧床一半的位置留给了书，为的是能够更便利地取书、读书，真正是以书为伴。'),
    (6,'《作为意志和表象的世界》','叔本华','商务印书馆','1982-11-11',48.00,480.00,9,100,648,'static/image/作为意志和表象的世界.jpg','全书分为四个部分： 一是“世界作为表象初论”，主要研究服从充足根据律的表象、经验和科学的客体，它们构成了一个表象的世界；二是“世界作为意志初论”，主要研究意志的客体化，它构成了一个意志的世界；三是“世界作为表象再论”，内容是关于理念和艺术的客体，它构成了一个理念的世界；四是“世界作为意志再论”，主要研究生命意态的肯定和否定，它构成了一个伦理的世界。这四部分内容体现了从认识论到本体论，到艺术论，再到伦理学的演变过程。'),
    (7,'《庄子》','庄周','中国社会科学出版社',' 2004-1-1',23.80,230.80,9,100,78,'static/image/庄子2.jpg','《庄子》是古代道家学派的重要经典，在唐朝又被尊称为《南华经》。其文汪洋瓷肆，幽默形象，多采用寓言故事，思想奔放新奇，充满机智和智慧。无论在哲学上和文学上都对后世产生了在其深远而巨大的影响'),
    (8,'《家风十章》','李存山','广西人民出版社','2016-12-12',34.00,59.00,10,39,50,'static/image/家风十章.jpg','《家风十章》这其中既包括对中国文化重视“家”的特殊性的认识，家文化与家风的关系，传统家风的核心精神，家风与修身立命、睦亲齐家、社会建构、国家治理的关系等，也包括传统家风的现代挑战，传统家风的现代化，以及面向未来的传统家风等。'),
    (9,'《亮剑》',' 都梁 ',' 解放军文艺出版社','2005-03-12',28.00,280.00,10,190,32,'static/image/亮剑.jpg','李云龙是一个叱咤风云、百战沙场的职业军人，是一个一生都在血与火中搏斗的名将。他的人生信条是：面对强大的对手，明知不敌，也要毅然亮剑，即使倒下，也要成为一座山、一道岭。在战争与和平的时空转换中，他的命运注定要充满悲欢离合—无论是政治生涯还是婚姻、爱情。');

    create table customer(
        customer_id int primary key auto_increment comment '用户编号',
        customer_name varchar(20) not null comment '账号名',
        customer_pwd varchar(6) not null comment '密码',
        customer_phone varchar(11) not null comment '电话号码',
        customer_address varchar(50) not null comment '用户地址',
        customer_email varchar(18) not null comment '邮箱',
        customer_type int not null comment '用户类型'/*0用户，1管理员，2店长*/
    ) comment '用户表';
    insert into customer(customer_name, customer_pwd, customer_phone, customer_address, customer_email,customer_type)
    values ( '石昊','111111','18370014961','江西省上饶市九天十地界','2060888745@qq.com',2),
           ('严元仪','222222','18370014962','江西省上饶市龙蛇演义界','2060888746@qq.com',1),
           ('龙青澜','333333','18370014963','江西省上饶市龙祭大陆界','2060888747@qq.com',1),
           ('苏尘','444444','18370014964','江苏省苏州市我是仙凡界','2060888748@qq.com',0);
    select * from customer;

    /*创建购物车表*/
    create table cart(
        cart_customer_id int primary key comment '购物车编号，用户号',
        cart_book_name varchar(50) not null comment '图书名',
        cart_book_sell_price decimal not null comment '单价',
        cart_book_count int not null comment '数量',
        cart_book_discount int not null comment '折扣',
        cart_book_allprice decimal not null comment '总价'
    ) comment '购物车';

    insert into cart(cart_customer_id, cart_book_name, cart_book_sell_price, cart_book_count, cart_book_discount, cart_book_allprice)
    values (4,'《吞噬星空》',390.00,1,9,351.00);
    select * from cart where cart_customer_id = 4;
    select * from customer;





    /*创建订单表,存放与用户有关的订单信息*/
    create table orders(
        order_id int primary key auto_increment comment '订单id',
        order_snid varchar(100) not null comment '订单编号',
        order_customer_id int comment '客户编号',
        order_reciver varchar(20) comment '接收者',
        order_phone varchar(11) comment '接收者号码',
        order_addr varchar(50) comment '接收地址',
        order_create_at varchar(50) comment '订单创建时间',
        order_pay_status int not null default '0' comment '订单支付状态',
                      /*订单支付状态，0为未支付，1为已支付*/
       order_last_create_at varchar(50) comment '订单最后修改时间'
    ) comment '订单表';
    insert into orders(order_snid, order_customer_id, order_reciver, order_phone, order_addr, order_create_at,order_pay_status, order_last_create_at)
    values ('11111111111',5,'admin','1111111111','fdjfaljd','2019-11-01',0,'2019-01-1');
    delete from orders where 1=1;

    create table order_detail(
        detail_id int primary key auto_increment comment '订单细节ID',
        detail_order_id int not null comment '订单ID',
        detail_customer_id int not null comment '客户ID',
        detail_book_name varchar(20) comment '图书名称',
        detail_book_price decimal(10,2) comment '图书价格',
        detail_book_amount int comment '图书数量',
        detail_book_discount double comment '订单折扣',
        detail_total_money decimal comment '订单总价'
     ) comment '订单细节表';
    insert into order_detail(detail_order_id, detail_customer_id, detail_book_name, detail_book_price, detail_book_amount, detail_book_discount, detail_total_money)
    values (1,5,'sfd',88,10,10,880);
