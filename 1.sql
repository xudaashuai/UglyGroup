CREATE TABLE public."users"
(
  sex         TEXT,
  age         INT,
  birthday    TEXT,
  favorite    TEXT,
  hate        TEXT,
  password    TEXT,
  userName    TEXT,
  nickName    TEXT,
  friendList  TEXT,
  follow      TEXT,
  fans        TEXT,
  sign        TEXT,
  trueId      INT PRIMARY KEY,
  headPicture TEXT
);
ALTER TABLE public.users
  ADD message TEXT NULL;

CREATE TABLE public.message
(
  id     INT PRIMARY KEY,
  type   INT,
  src    INT,
  dst    INT,
  body   TEXT,
  status INT,
  time   TIMESTAMP
);
CREATE TABLE public.comment (
  commentId   INT PRIMARY KEY,
  shopId      INT,
  userId      INT,
  commentBody TEXT,
  score       INT,
  time        TEXT
);

CREATE TABLE public.shop
(
  id INT PRIMARY KEY,
  name TEXT,
  loction TEXT,
  address TEXT,
  star INT,
  price INT,
  phone TEXT,
  recommend_thing TEXT,
  simple_info TEXT,
  long_info TEXT
);
ALTER TABLE public.shop ADD type TEXT NULL;
ALTER TABLE public.shop ADD inRank TEXT NULL;
ALTER TABLE public.shop ADD comment TEXT NULL;
ALTER TABLE public.shop ADD time TEXT NULL;
ALTER TABLE public.shop ADD parking TEXT NULL;
ALTER TABLE public.shop ADD wifi TEXT NULL;