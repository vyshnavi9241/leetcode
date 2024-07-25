# Write your MySQL query statement below
# Write your MySQL query statemen t below
SELECT name
FROM Customer
WHERE IFNULL(referee_id, 0) != 2;