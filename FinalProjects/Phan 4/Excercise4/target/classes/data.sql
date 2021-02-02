-- /*
--  Navicat Premium Data Transfer

--  Source Server         : cleanCode
--  Source Server Type    : PostgreSQL
--  Source Server Version : 130001
--  Source Host           : localhost:5432
--  Source Catalog        : postgres
--  Source Schema         : public

--  Target Server Type    : PostgreSQL
--  Target Server Version : 130001
--  File Encoding         : 65001

--  Date: 02/02/2021 08:52:16
-- */


-- -- ----------------------------
-- -- Table structure for course
-- -- ----------------------------
-- DROP TABLE IF EXISTS "course";
-- CREATE TABLE "course" (
--   "course_id" int4 NOT NULL,
--   "course_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
--   "description" text COLLATE "pg_catalog"."default",
--   "location" varchar(255) COLLATE "pg_catalog"."default",
--   "opened" date,
--   "teacher_id" int4
-- )
-- ;

-- -- ----------------------------
-- -- Table structure for enroll
-- -- ----------------------------
-- DROP TABLE IF EXISTS "enroll";
-- CREATE TABLE "enroll" (
--   "student_id" int4,
--   "course_id" int4
-- )
-- ;

-- -- ----------------------------
-- -- Table structure for student
-- -- ----------------------------
-- DROP TABLE IF EXISTS "student";
-- CREATE TABLE "student" (
--   "user_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
--   "year" varchar(10) COLLATE "pg_catalog"."default",
--   "student_id" int4 NOT NULL,
--   "email" varchar(100) COLLATE "pg_catalog"."default",
--   "password" varchar(20) COLLATE "pg_catalog"."default"
-- )
-- ;

-- -- ----------------------------
-- -- Table structure for teacher
-- -- ----------------------------
-- DROP TABLE IF EXISTS "teacher";
-- CREATE TABLE "teacher" (
--   "phone" varchar(50) COLLATE "pg_catalog"."default",
--   "experiences" int4,
--   "teacher_id" int4 NOT NULL,
--   "user_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
--   "email" varchar(100) COLLATE "pg_catalog"."default",
--   "password" varchar(20) COLLATE "pg_catalog"."default"
-- )
-- ;

-- -- ----------------------------
-- -- Table structure for user
-- -- ----------------------------
-- DROP TABLE IF EXISTS "user";
-- CREATE TABLE "user" (
--   "user_id" int4 NOT NULL,
--   "user_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
--   "email" varchar(100) COLLATE "pg_catalog"."default",
--   "password" varchar(20) COLLATE "pg_catalog"."default"
-- )
-- ;

-- -- ----------------------------
-- -- Primary Key structure for table course
-- -- ----------------------------
-- ALTER TABLE "course" ADD CONSTRAINT "course_pkey" PRIMARY KEY ("course_id");

-- -- ----------------------------
-- -- Primary Key structure for table student
-- -- ----------------------------
-- ALTER TABLE "student" ADD CONSTRAINT "student_pkey" PRIMARY KEY ("student_id");

-- -- ----------------------------
-- -- Primary Key structure for table teacher
-- -- ----------------------------
-- ALTER TABLE "teacher" ADD CONSTRAINT "teacher_pkey" PRIMARY KEY ("teacher_id");

-- -- ----------------------------
-- -- Primary Key structure for table user
-- -- ----------------------------
-- ALTER TABLE "user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("user_id");

-- -- ----------------------------
-- -- Foreign Keys structure for table course
-- -- ----------------------------
-- ALTER TABLE "course" ADD CONSTRAINT "course_teacher_id_fkey" FOREIGN KEY ("teacher_id") REFERENCES "teacher" ("teacher_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- -- ----------------------------
-- -- Foreign Keys structure for table enroll
-- -- ----------------------------
-- ALTER TABLE "enroll" ADD CONSTRAINT "enroll_course_id_fkey" FOREIGN KEY ("course_id") REFERENCES "course" ("course_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ALTER TABLE "enroll" ADD CONSTRAINT "enroll_student_id_fkey" FOREIGN KEY ("student_id") REFERENCES "student" ("student_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
