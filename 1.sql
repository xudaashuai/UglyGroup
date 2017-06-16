
CREATE TABLE public."users"
(
  sex TEXT,
  age INT,
  birthday TEXT,
  favorite TEXT,
  hate TEXT,
  password TEXT,
  userName TEXT,
  nickName TEXT,
  friendList TEXT,
  follow TEXT,
  fans TEXT,
  sign TEXT,
  trueId INT PRIMARY KEY,
  headPicture TEXT
);
ALTER TABLE public.users ADD message TEXT NULL;

CREATE TABLE public.message
(
  id INT PRIMARY KEY,
  type INT,
  src INT,
  dst INT,
  body TEXT,
  status INT,
  time TIMESTAMP
);