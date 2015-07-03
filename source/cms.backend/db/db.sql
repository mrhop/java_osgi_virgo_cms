/*
Navicat PGSQL Data Transfer

Source Server         : 61.161.196.190
Source Server Version : 90107
Source Host           : 61.161.196.190:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90107
File Encoding         : 65001

Date: 2015-06-23 15:42:29
*/


-- ----------------------------
-- Sequence structure for cms_element_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_element_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cms_element_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for cms_element_lang_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_element_lang_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for cms_element_template_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_element_template_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cms_element_template_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for cms_page_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_page_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cms_page_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for cms_page_lang_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_page_lang_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for cms_page_template_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_page_template_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cms_page_template_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for cms_user_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_user_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for cms_website_config_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_website_config_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for cms_website_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."cms_website_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cms_website_id_seq"', 1, true);

-- ----------------------------
-- Table structure for cms_element
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_element";
CREATE TABLE "public"."cms_element" (
"id" int4 DEFAULT nextval('cms_element_id_seq'::regclass) NOT NULL,
"name" char(255) COLLATE "default",
"type" int4,
"element_template_id" int4,
"website_id" int4,
"element_code" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_element_lang
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_element_lang";
CREATE TABLE "public"."cms_element_lang" (
"id" int4 DEFAULT nextval('cms_element_lang_id_seq'::regclass) NOT NULL,
"lang_id" int4,
"content" text COLLATE "default",
"element_id" int4,
"page_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_element_template
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_element_template";
CREATE TABLE "public"."cms_element_template" (
"id" int4 DEFAULT nextval('cms_element_template_id_seq'::regclass) NOT NULL,
"name" char(255) COLLATE "default",
"template" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_page
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_page";
CREATE TABLE "public"."cms_page" (
"id" int4 DEFAULT nextval('cms_page_id_seq'::regclass) NOT NULL,
"name" char(255) COLLATE "default",
"parent_page_id" int4,
"website_id" int4,
"page_template_id" int4,
"status" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_page_lang
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_page_lang";
CREATE TABLE "public"."cms_page_lang" (
"id" int4 DEFAULT nextval('cms_page_lang_id_seq'::regclass) NOT NULL,
"lang_id" int4,
"page_id" int4,
"title" char(255) COLLATE "default",
"keywords" char(255) COLLATE "default",
"page_url" char(255) COLLATE "default",
"description" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_page_template
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_page_template";
CREATE TABLE "public"."cms_page_template" (
"id" int4 DEFAULT nextval('cms_page_template_id_seq'::regclass) NOT NULL,
"name" char(255) COLLATE "default",
"template" text COLLATE "default",
"website_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_user";
CREATE TABLE "public"."cms_user" (
"id" int4 DEFAULT nextval('cms_user_id_seq'::regclass) NOT NULL,
"privilege_content" bool,
"privilege_template" bool,
"privilege_element" bool,
"privilege_user" bool,
"name" text COLLATE "default",
"status" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_website
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_website";
CREATE TABLE "public"."cms_website" (
"id" int4 DEFAULT nextval('cms_website_id_seq'::regclass) NOT NULL,
"name" char(255) COLLATE "default",
"base_url" char(255) COLLATE "default",
"status" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cms_website_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."cms_website_config";
CREATE TABLE "public"."cms_website_config" (
"id" int4 DEFAULT nextval('cms_website_config_id_seq'::regclass) NOT NULL,
"username" char(255) COLLATE "default",
"password" char(255) COLLATE "default",
"website_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."cms_element_lang_id_seq" OWNED BY "cms_element_lang"."id";
ALTER SEQUENCE "public"."cms_element_template_id_seq" OWNED BY "cms_element_template"."id";
ALTER SEQUENCE "public"."cms_page_id_seq" OWNED BY "cms_page"."id";
ALTER SEQUENCE "public"."cms_page_lang_id_seq" OWNED BY "cms_page_lang"."id";
ALTER SEQUENCE "public"."cms_page_template_id_seq" OWNED BY "cms_page_template"."id";
ALTER SEQUENCE "public"."cms_user_id_seq" OWNED BY "cms_user"."id";
ALTER SEQUENCE "public"."cms_website_config_id_seq" OWNED BY "cms_website_config"."id";

-- ----------------------------
-- Primary Key structure for table cms_element_lang
-- ----------------------------
ALTER TABLE "public"."cms_element_lang" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_element_template
-- ----------------------------
ALTER TABLE "public"."cms_element_template" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_page
-- ----------------------------
ALTER TABLE "public"."cms_page" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_page_lang
-- ----------------------------
ALTER TABLE "public"."cms_page_lang" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_page_template
-- ----------------------------
ALTER TABLE "public"."cms_page_template" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_user
-- ----------------------------
ALTER TABLE "public"."cms_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cms_website_config
-- ----------------------------
ALTER TABLE "public"."cms_website_config" ADD PRIMARY KEY ("id");
