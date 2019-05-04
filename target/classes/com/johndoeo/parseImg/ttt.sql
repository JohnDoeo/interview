
SELECT  t3.id,
t3.country,
t3.score    FROM  (
SELECT  t1.*, (
SELECT  count( * )   FROM  tb_score t2  WHERE  t1.score <= t2.score  AND  t1.country = t2.country
)   AS  rownum                 FROM  tb_score t1
)   t3    WHERE  rownum  <= 3  ORDER BY  country,
score  DESC;  

select a.id,a.country,a.name,a.score from tb_score a   
where exists   
(select count(*) from tb_score where country = a.country and score > a.score having Count(*) < 3)  
order by a.country,score DESC;  