--
-- Kingbase database dump
--

SET client_encoding = 'GBK';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = "PUBLIC";

CREATE SEQUENCE "SEQ"
    INCREMENT BY 1
    MAXVALUE 10000000
    NO MINVALUE
    CACHE 1;


ALTER TABLE "SEQ" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"SEQ"', 5, true);


CREATE SEQUENCE "achievement_check_template_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "achievement_check_template_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"achievement_check_template_id_seq"', 2, true);


SET default_tablespace = "SYSTEM";

SET default_with_oids = false;

CREATE TABLE "achievement_check_template" (
    "template_id" INTEGER DEFAULT NEXTVAL('"achievement_check_template_id_seq"'::REGCLASS) NOT NULL,
    "template_type" TEXT NOT NULL,
    "template_name" CHARACTER VARYING(255 CHAR) NOT NULL,
    "template_intro" TEXT NOT NULL,
    "remarks" TEXT NOT NULL,
    "upload_time" DATE NOT NULL,
    "user_id" INTEGER,
    "version_number" CHARACTER VARYING(16 CHAR) NOT NULL,
    "template_storagepath" CHARACTER VARYING(255 CHAR) NOT NULL,
    "table_status" BOOLEAN NOT NULL,
    "review_status" BOOLEAN NOT NULL,
    "update_time" DATE NOT NULL
);


ALTER TABLE "achievement_check_template" OWNER TO "SYSTEM";

CREATE SEQUENCE "achievement_table_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "achievement_table_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"achievement_table_id_seq"', 14, true);


CREATE TABLE "achievement_table" (
    "achievement_id" INTEGER DEFAULT NEXTVAL('"achievement_table_id_seq"'::REGCLASS) NOT NULL,
    "achievement_name" CHARACTER VARYING(255 CHAR),
    "achievement_category" TEXT,
    "achievement_form" CHARACTER VARYING(255 CHAR),
    "intellectual_property_id" INTEGER,
    "achievement_belonging_organization" INTEGER,
    "project_id" INTEGER,
    "achievement_version" CHARACTER VARYING(16 CHAR),
    "achievement_intro" TEXT,
    "user_id" INTEGER,
    "upload_time" DATE,
    "template_id" INTEGER,
    "remarks" TEXT,
    "achievement_download_count" INTEGER,
    "search_count" INTEGER,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "achievement_table" OWNER TO "SYSTEM";

CREATE SEQUENCE "approval_records_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "approval_records_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"approval_records_id_seq"', 9, true);


CREATE TABLE "approval_records" (
    "approval_id" INTEGER DEFAULT NEXTVAL('"approval_records_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "approval_type" CHARACTER VARYING(16 CHAR) NOT NULL,
    "approval_status" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "approval_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "approval_records" OWNER TO "SYSTEM";

CREATE SEQUENCE "download_records_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "download_records_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"download_records_id_seq"', 1, false);


CREATE TABLE "download_records" (
    "download_id" INTEGER DEFAULT NEXTVAL('"download_records_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "template_id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "download_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "download_records" OWNER TO "SYSTEM";

CREATE SEQUENCE "file_record_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "file_record_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"file_record_id_seq"', 1, false);


CREATE TABLE "file_record" (
    "file_id" INTEGER DEFAULT NEXTVAL('"file_record_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "file_name" CHARACTER VARYING(40 CHAR) NOT NULL,
    "upload_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL,
    "project_id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL
);


ALTER TABLE "file_record" OWNER TO "SYSTEM";

CREATE SEQUENCE "intellectual_property_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "intellectual_property_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"intellectual_property_id_seq"', 4, true);


CREATE TABLE "intellectual_property" (
    "intellectual_property_id" INTEGER DEFAULT NEXTVAL('"intellectual_property_id_seq"'::REGCLASS) NOT NULL,
    "intellectual_property_type" TEXT NOT NULL,
    "application_date" DATE NOT NULL,
    "expiration_date" DATE NOT NULL,
    "renewal_status" BOOLEAN NOT NULL,
    "table_status" BOOLEAN NOT NULL,
    "achievement_id" INTEGER NOT NULL
);


ALTER TABLE "intellectual_property" OWNER TO "SYSTEM";

CREATE SEQUENCE "intellectual_property_applications_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "intellectual_property_applications_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"intellectual_property_applications_id_seq"', 1, false);


CREATE TABLE "intellectual_property_applications" (
    "application_id" INTEGER DEFAULT NEXTVAL('"intellectual_property_applications_id_seq"'::REGCLASS) NOT NULL,
    "user_id" INTEGER NOT NULL,
    "consultation_type" TEXT NOT NULL,
    "consultation_content" TEXT NOT NULL,
    "consultation_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "intellectual_property_applications" OWNER TO "SYSTEM";

CREATE SEQUENCE "interaction_evaluation_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "interaction_evaluation_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"interaction_evaluation_id_seq"', 1, false);


CREATE TABLE "interaction_evaluation" (
    "interaction_id" INTEGER DEFAULT NEXTVAL('"interaction_evaluation_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "rating" INTEGER NOT NULL,
    "evaluation" TEXT NOT NULL,
    "interaction_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "interaction_evaluation" OWNER TO "SYSTEM";

CREATE SEQUENCE "log_records_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "log_records_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"log_records_id_seq"', 1, false);


CREATE TABLE "log_records" (
    "log_id" INTEGER DEFAULT NEXTVAL('"log_records_id_seq"'::REGCLASS) NOT NULL,
    "user_id" INTEGER NOT NULL,
    "log_intro" TEXT NOT NULL,
    "log_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "log_records" OWNER TO "SYSTEM";

CREATE SEQUENCE "organization_info_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "organization_info_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"organization_info_id_seq"', 1, true);


CREATE TABLE "organization_info" (
    "organization_id" INTEGER DEFAULT NEXTVAL('"organization_info_id_seq"'::REGCLASS) NOT NULL,
    "organization_name" CHARACTER VARYING(255 CHAR) NOT NULL,
    "organization_project_count" INTEGER NOT NULL,
    "organization_project_total_count" INTEGER NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "organization_info" OWNER TO "SYSTEM";

CREATE SEQUENCE "patent_complaints_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "patent_complaints_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"patent_complaints_id_seq"', 1, false);


CREATE TABLE "patent_complaints" (
    "complaint_id" INTEGER DEFAULT NEXTVAL('"patent_complaints_id_seq"'::REGCLASS) NOT NULL,
    "intellectual_property_id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "complaint_time" DATE NOT NULL,
    "processing_status" CHARACTER VARYING(16 CHAR) NOT NULL,
    "infringement_complaint_type" TEXT NOT NULL,
    "complaint_intro" TEXT NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "patent_complaints" OWNER TO "SYSTEM";

CREATE SEQUENCE "project_records_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "project_records_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"project_records_id_seq"', 1, false);


CREATE TABLE "project_records" (
    "project_id" INTEGER DEFAULT NEXTVAL('"project_records_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "project_name" CHARACTER VARYING(255 CHAR) NOT NULL,
    "organization_id" INTEGER NOT NULL,
    "project_intro" TEXT NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "project_records" OWNER TO "SYSTEM";

CREATE SEQUENCE "role_table_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "role_table_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"role_table_id_seq"', 22, true);


CREATE TABLE "role_table" (
    "role_id" INTEGER DEFAULT NEXTVAL('"role_table_id_seq"'::REGCLASS) NOT NULL,
    "role_name" CHARACTER VARYING(255 CHAR) NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "role_table" OWNER TO "SYSTEM";

CREATE SEQUENCE "search_records_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "search_records_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"search_records_id_seq"', 1, false);


CREATE TABLE "search_records" (
    "search_id" INTEGER DEFAULT NEXTVAL('"search_records_id_seq"'::REGCLASS) NOT NULL,
    "user_id" INTEGER NOT NULL,
    "search_content" TEXT NOT NULL,
    "search_time" DATE NOT NULL,
    "search_method" INTEGER NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "search_records" OWNER TO "SYSTEM";

CREATE SEQUENCE "statistics_info_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "statistics_info_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"statistics_info_id_seq"', 1, false);


CREATE TABLE "statistics_info" (
    "statistic_id" INTEGER DEFAULT NEXTVAL('"statistics_info_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "download_count" INTEGER NOT NULL,
    "averagerating" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "statistic_time" DATE NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "statistics_info" OWNER TO "SYSTEM";

CREATE SEQUENCE "user_role_permissions_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "user_role_permissions_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"user_role_permissions_id_seq"', 6, true);


CREATE TABLE "user_role_permissions" (
    "user_id" INTEGER DEFAULT NEXTVAL('"user_role_permissions_id_seq"'::REGCLASS) NOT NULL,
    "user_name" CHARACTER VARYING(16 CHAR) NOT NULL,
    "role_id" INTEGER NOT NULL,
    "user_status" INTEGER NOT NULL,
    "application_time" DATE NOT NULL,
    "user_intro" CHARACTER VARYING(16 CHAR),
    "table_status" BOOLEAN NOT NULL,
    "user_pwd" CHARACTER VARYING(256 CHAR)
);


ALTER TABLE "user_role_permissions" OWNER TO "SYSTEM";

CREATE SEQUENCE "version_history_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE "version_history_id_seq" OWNER TO "SYSTEM";

SELECT sys_catalog.setval('"version_history_id_seq"', 1, false);


CREATE TABLE "version_history" (
    "version_id" INTEGER DEFAULT NEXTVAL('"version_history_id_seq"'::REGCLASS) NOT NULL,
    "achievement_id" INTEGER NOT NULL,
    "version_number" CHARACTER VARYING(16 CHAR) NOT NULL,
    "update_content" TEXT NOT NULL,
    "update_time" DATE NOT NULL,
    "user_id" INTEGER NOT NULL,
    "table_status" BOOLEAN NOT NULL
);


ALTER TABLE "version_history" OWNER TO "SYSTEM";

INSERT INTO "achievement_check_template" ("template_id", "template_type", "template_name", "template_intro", "remarks", "upload_time", "user_id", "version_number", "template_storagepath", "table_status", "review_status", "update_time") VALUES (2, 'word', '成果模板测试1', '无', '无', '2024-12-10', 1, '1.0', '/path/to/file', true, false, '2024-12-10');


INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (2, '猪八戒', '论文', 'laborum ut consequat Duis cillum', 88, 78, 76, 'qui Ut ut', 'culpa', 97, '2024-09-22', 93, 'ex', 31, 34, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (4, '孙策', '其他成果', 'ea dolore', 88, 5, 30, 'cillum', 'culpa', 1, '2025-01-13', 6, 'ex', 81, 52, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (5, '肖申克的救赎', '其他成果', 'ut', 14, 49, 12, 'V1.0', '无', 10, '2024-10-18', 55, '无', 73, 94, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (7, '我不是药神', '专利', 'quis aat', 50, 9, 28, 'V1.0', '无', 81, '2025-12-01', 73, '无', 59, 78, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (8, '雪中悍刀行', '其他成果', 'elit fiat', 83, 90, 29, 'V1.0', '无', 67, '2024-12-09', 77, '无', 75, 57, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (9, '剑来', '其他成果', 'elit fiat', 83, 90, 29, 'V1.0', '无', 67, '2024-12-09', 77, '无', 75, 57, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (10, '绿水亭甲子习剑录', '论文', 'elit fiat', 83, 90, 29, 'V1.0', '无', 67, '2024-12-09', 77, '无', 75, 57, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (11, '斗破苍穹', '专利', 'proident', 70, 85, 9, 'V1.0', '无', 7, '2024-06-01', 49, '无', 8, 87, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (12, '斗罗大陆', '其他成果', 'Ut', 93, 26, 26, 'V1.0', '无', 38, '2025-07-26', 36, '无', 17, 58, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (13, '武动乾坤', '其他成果', 'nisi velit aliqua mollit', 65, 35, 30, 'V1.0', '无', 97, '2024-06-22', 38, '无', 44, 99, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (6, '神偷奶爸', '专利', 'in tempor', 100, 36, 64, 'V1.0', '无', 8, '2025-04-14', 12, '无', 42, 49, false);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (1, '喜羊羊', '绵羊', 'reprehenderit', 1, 18, 74, 'ullamcoa', '羊村跑的最快', 83, '2025-03-26', 92, 'ex', 42, 87, true);
INSERT INTO "achievement_table" ("achievement_id", "achievement_name", "achievement_category", "achievement_form", "intellectual_property_id", "achievement_belonging_organization", "project_id", "achievement_version", "achievement_intro", "user_id", "upload_time", "template_id", "remarks", "achievement_download_count", "search_count", "table_status") VALUES (14, '误杀3', '发明专利', '电影', 3, 5, 11, 'V1.0', '无', 83, '2024-11-04', 94, '无', 6, 4, true);


INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (4, 4, 'non', 0, 69, '2025-06-23', true);
INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (5, 73, 'qui', 2, 8, '2025-06-16', true);
INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (7, 13, 'eu', 1, 63, '2024-01-19', true);
INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (8, 12, 'hh', 1, 66, '2024-01-19', true);
INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (2, 2, 'in', 0, 1, '2024-04-21', true);
INSERT INTO "approval_records" ("approval_id", "achievement_id", "approval_type", "approval_status", "user_id", "approval_time", "table_status") VALUES (9, 11, 'in', 1, 1, '2024-04-21', true);






INSERT INTO "intellectual_property" ("intellectual_property_id", "intellectual_property_type", "application_date", "expiration_date", "renewal_status", "table_status", "achievement_id") VALUES (2, '发明专利', '2025-01-01', '2026-01-02', true, true, 7);
INSERT INTO "intellectual_property" ("intellectual_property_id", "intellectual_property_type", "application_date", "expiration_date", "renewal_status", "table_status", "achievement_id") VALUES (3, '发明专利', '2025-01-01', '2025-01-02', false, true, 14);
INSERT INTO "intellectual_property" ("intellectual_property_id", "intellectual_property_type", "application_date", "expiration_date", "renewal_status", "table_status", "achievement_id") VALUES (1, '国防专利', '2025-01-01', '2026-01-03', true, true, 11);
INSERT INTO "intellectual_property" ("intellectual_property_id", "intellectual_property_type", "application_date", "expiration_date", "renewal_status", "table_status", "achievement_id") VALUES (4, '国防专利', '2025-01-01', '2026-01-25', true, true, 3);








INSERT INTO "organization_info" ("organization_id", "organization_name", "organization_project_count", "organization_project_total_count", "table_status") VALUES (1, 'cetc32', 41, 5, true);






INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (1, 'Java', true);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (2, 'Python', true);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (3, 'C++', true);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (19, 'Rust', true);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (20, '谢超', false);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (21, '谢超', false);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (4, 'SQL', false);
INSERT INTO "role_table" ("role_id", "role_name", "table_status") VALUES (22, '秘婷婷', true);






INSERT INTO "user_role_permissions" ("user_id", "user_name", "role_id", "user_status", "application_time", "user_intro", "table_status", "user_pwd") VALUES (3, '化建军', 3, 2, '2025-11-22', 'magnaerunt', true, 'deserunt');
INSERT INTO "user_role_permissions" ("user_id", "user_name", "role_id", "user_status", "application_time", "user_intro", "table_status", "user_pwd") VALUES (5, 'admin', 1, 2, '2024-12-30', 'sunt', true, 'admin');
INSERT INTO "user_role_permissions" ("user_id", "user_name", "role_id", "user_status", "application_time", "user_intro", "table_status", "user_pwd") VALUES (4, '沙天娇', 2, 1, '2025-03-31', '无', false, '12345678');
INSERT INTO "user_role_permissions" ("user_id", "user_name", "role_id", "user_status", "application_time", "user_intro", "table_status", "user_pwd") VALUES (1, 'dasda', 3, 3, '2024-12-02', 'no', true, 'dasda');
INSERT INTO "user_role_permissions" ("user_id", "user_name", "role_id", "user_status", "application_time", "user_intro", "table_status", "user_pwd") VALUES (6, '萧炎', 1, 2, '2025-07-30', '萧家', true, 'xiaoyan');




ALTER TABLE ONLY "achievement_check_template"
    ADD CONSTRAINT "achievement_check_template_PKEY" PRIMARY KEY ("template_id");


ALTER TABLE ONLY "achievement_table"
    ADD CONSTRAINT "achievement_table_PKEY" PRIMARY KEY ("achievement_id");


ALTER TABLE ONLY "approval_records"
    ADD CONSTRAINT "approval_records_PKEY" PRIMARY KEY ("approval_id");


ALTER TABLE ONLY "download_records"
    ADD CONSTRAINT "download_records_PKEY" PRIMARY KEY ("download_id");


ALTER TABLE ONLY "file_record"
    ADD CONSTRAINT "file_record_PKEY" PRIMARY KEY ("file_id");


ALTER TABLE ONLY "intellectual_property"
    ADD CONSTRAINT "intellectual_property_PKEY" PRIMARY KEY ("intellectual_property_id");


ALTER TABLE ONLY "intellectual_property_applications"
    ADD CONSTRAINT "intellectual_property_applications_PKEY" PRIMARY KEY ("application_id");


ALTER TABLE ONLY "interaction_evaluation"
    ADD CONSTRAINT "interaction_evaluation_PKEY" PRIMARY KEY ("interaction_id");


ALTER TABLE ONLY "log_records"
    ADD CONSTRAINT "log_records_PKEY" PRIMARY KEY ("log_id");


ALTER TABLE ONLY "organization_info"
    ADD CONSTRAINT "organization_info_PKEY" PRIMARY KEY ("organization_id");


ALTER TABLE ONLY "patent_complaints"
    ADD CONSTRAINT "patent_complaints_PKEY" PRIMARY KEY ("complaint_id");


ALTER TABLE ONLY "project_records"
    ADD CONSTRAINT "project_records_PKEY" PRIMARY KEY ("project_id");


ALTER TABLE ONLY "role_table"
    ADD CONSTRAINT "role_table_PKEY" PRIMARY KEY ("role_id");


ALTER TABLE ONLY "search_records"
    ADD CONSTRAINT "search_records_PKEY" PRIMARY KEY ("search_id");


ALTER TABLE ONLY "statistics_info"
    ADD CONSTRAINT "statistics_info_PKEY" PRIMARY KEY ("statistic_id");


ALTER TABLE ONLY "user_role_permissions"
    ADD CONSTRAINT "user_role_permissions_PKEY" PRIMARY KEY ("user_id");


ALTER TABLE ONLY "version_history"
    ADD CONSTRAINT "version_history_PKEY" PRIMARY KEY ("version_id");


REVOKE ALL ON SCHEMA "PUBLIC" FROM PUBLIC;
REVOKE ALL ON SCHEMA "PUBLIC" FROM "SYSTEM";
GRANT ALL ON SCHEMA "PUBLIC" TO "SYSTEM";
GRANT ALL ON SCHEMA "PUBLIC" TO PUBLIC;


--
-- Kingbase database dump complete
--

