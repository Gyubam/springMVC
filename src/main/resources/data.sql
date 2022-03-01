INSERT INTO article(id, title, content) VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES (2, '나나나나', '2222');
INSERT INTO article(id, title, content) VALUES (3, '다다다다', '3333');

-- article 더미 데이터
INSERT INTO article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES (5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '당신의 취미는?', '댓글 ㄱㄱㄱ');


-- comment 더미 데이터
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Park', '굳 월 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Kim', '아이엠 생');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Choi', '내부자들');

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Kim', '순대국밥');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Choi', '돈까스');

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'Park', '조깅하기');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'Kim', '영화보기');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'Choi', '게임하기');
