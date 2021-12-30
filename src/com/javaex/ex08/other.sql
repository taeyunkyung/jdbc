select  bo.book_id,
        bo.title,
        bo.pubs,
        bo.pub_date,
        au.author_name
from book bo, author au
where (bo.author_id = au.author_id and bo.title like '%문%')
or    (bo.author_id = au.author_id and bo.pubs like '%문%')
or    (bo.author_id = au.author_id and au.author_name like '%문%')
order by bo.book_id asc;   
       
select  ba.book_id,
        ba.title,
        ba.pubs,
        ba.pub_date,
        ba.author_name
from   (select  bo.book_id,
                bo.title,
                bo.pubs,
                bo.pub_date,
                au.author_name
        from book bo, author au
        where bo.author_id = au.author_id) ba
where ba.title like '%문%'
or ba.pubs like '%문%'
or ba.author_name like '%문%'
order by ba.book_id asc;

select  bo.book_id,
        bo.title,
        bo.pubs,
        bo.pub_date,
        au.author_name
from book bo left join author au  --left full 조인도 데이타 상태에 따라 가능
on bo.author_id = au.author_id
where bo.title like '%문%'
or bo.pubs like '%문%'
or au.author_name like '%문%'
order by bo.book_id asc;