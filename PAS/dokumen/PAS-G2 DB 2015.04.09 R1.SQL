--==============================================================
-- DBMS name:      IBM DB2 UDB 9.7 Common Server
-- Created on:     4/9/2015 11:32:43 AM
--==============================================================


--==============================================================
-- Table: PAS_EA_USERGROUP
--==============================================================
create table PAS_EA_USERGROUP
(
   KODE_USERGROUP			BIGINT                 not null
					generated always as identity,
   NAMA_USERGROUP			VARCHAR(64)            not null,
   KETERANGAN_USERGROUP			VARCHAR(256),
   TK_USERGROUP				BIGINT                 not null,
   STATUS_USERGROUP			CHAR(1)                not null
					constraint C_STATUS_USERGROUP check (STATUS_USERGROUP in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERGROUP)
);

--==============================================================
-- Table: PAS_EA_USER
--==============================================================
create table PAS_EA_USER
(
   KODE_USERGROUP			BIGINT                 not null,
   KODE_USER				BIGINT                 not null unique
					generated always as identity,
   USERNAME				VARCHAR(32)            not null,
   PASSWORD				VARCHAR(32)            not null,
   NIK					VARCHAR(8)             not null,
   NAMA					VARCHAR(64)            not null,
   NO_HP				VARCHAR(16),
   EMAIL				VARCHAR(64),
   PENEMPATAN			        CHAR(1)                not null
					constraint C_PENEMPATAN check (PENEMPATAN in ('P','W')),
   STATUS_USER				CHAR(1)                not null
					constraint C_STATUS_USER check (STATUS_USER in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERGROUP, KODE_USER),
   constraint F_EAUG_EAU foreign key (KODE_USERGROUP)
         references PAS_EA_USERGROUP (KODE_USERGROUP)
         on delete restrict on update restrict,
   constraint F_EAU_EAU foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_PPL_USER
--==============================================================
create table PAS_EA_PPL_USER
(
   KODE_USERGROUP			BIGINT                 not null,
   KODE_USER				BIGINT                 not null,
   KODE_PPL_USER			BIGINT                 not null
					generated always as identity,
   NAMA_PPL				VARCHAR(64)            not null,
   PENYELENGGARA_PPL			VARCHAR(64)            not null,
   TGL_AWAL_PPL				DATE                   not null,
   TGL_AKHIR_PPL			DATE                   not null,
   LAMA_PPL				BIGINT                 not null
					constraint C_LAMA_PPL check (LAMA_PPL >= 1),
   NAMA_FILE_BUKTI_PPL			VARCHAR(64),
   FILE_BUKTI_PPL			LONG VARGRAPHIC,
   NILAI				SMALLINT,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERGROUP, KODE_USER, KODE_PPL_USER),
   constraint F_EAU_EAPPLU foreign key (KODE_USERGROUP, KODE_USER)
         references PAS_EA_USER (KODE_USERGROUP, KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_EAPPLU_UPDATE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_AK_PENILAIAN_MUTU
--==============================================================
create table PAS_AK_PENILAIAN_MUTU
(
   KODE_PKPI_PENILAIAN_MUTU		BIGINT                 not null,
   KODE_PENILAIAN_MUTU			BIGINT                 not null
					generated always as identity,
   TANGGAL_PENILAIAN_MUTU		DATE                   not null,
   CATATAN_PENILAIAN_MUTU		VARCHAR(1024),
   KODE_USER_PENILAI_MUTU		BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PENILAIAN_MUTU, KODE_PKPI_PENILAIAN_MUTU),
   constraint F_EAU_AKPM_PENILAI foreign key (KODE_USER_PENILAI_MUTU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_AKPM foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_VARIABEL_MUTU
--==============================================================
create table PAS_KS_VARIABEL_MUTU
(
   KODE_VARIABEL_MUTU			BIGINT                 not null
					generated always as identity,
   VARIABEL_MUTU			VARCHAR(64)            not null,
   BOBOT_VARIABEL_MUTU			DECIMAL(5,2)           not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_VARIABEL_MUTU),
   constraint F_EAU_KSVM foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_AK_NILAI_PENILAIAN_MUTU
--==============================================================
create table PAS_AK_NILAI_PENILAIAN_MUTU
(
   KODE_PKPI_PENILAIAN_MUTU		BIGINT                 not null,
   KODE_PENILAIAN_MUTU			BIGINT                 not null,
   KODE_NILAI_PENILAIAN_MUTU		BIGINT                 not null
					generated always as identity,
   KODE_VARIABEL_MUTU			BIGINT,
   NILAI				DECIMAL(5,2)           not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_KEY_1 primary key (KODE_NILAI_PENILAIAN_MUTU, KODE_PENILAIAN_MUTU, KODE_PKPI_PENILAIAN_MUTU),
   constraint F_AKPM_AKNPM foreign key (KODE_PENILAIAN_MUTU, KODE_PKPI_PENILAIAN_MUTU)
         references PAS_AK_PENILAIAN_MUTU (KODE_PENILAIAN_MUTU, KODE_PKPI_PENILAIAN_MUTU)
         on delete restrict on update restrict,
   constraint F_KSVM_AKNPM foreign key (KODE_VARIABEL_MUTU)
         references PAS_KS_VARIABEL_MUTU (KODE_VARIABEL_MUTU)
         on delete restrict on update restrict,
   constraint F_EAU_AKNPM foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_TK_KANTOR_AUDITOR
--==============================================================
create table PAS_EA_TK_KANTOR_AUDITOR
(
   KODE_TK_KANTOR_AUDITOR		BIGINT                 not null
					generated always as identity,
   NAMA_TK_KANTOR_AUDITOR		VARCHAR(64)            not null,
   KETERANGAN_TK_KANTOR_AUDITOR		VARCHAR(256),
   TK_KANTOR_AUDITOR			BIGINT                 not null,
   STATUS_TK_KANTOR_AUDITOR		CHAR(1)                not null
					constraint C_STATUS_TK_KANTOR check (STATUS_TK_KANTOR_AUDITOR in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_KANTOR_AUDITOR),
   constraint F_EAU_EATKKA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_KANTOR_AUDITOR
--==============================================================
create table PAS_EA_KANTOR_AUDITOR
(
   KODE_TK_KANTOR_AUDITOR		BIGINT                 not null,
   KODE_KANTOR_AUDITOR			BIGINT                 not null unique
					generated always as identity,
   NAMA_KANTOR_AUDITOR			VARCHAR(64)            not null,
   ALAMAT_KANTOR_AUDITOR		VARCHAR(128)           not null,
   KOTA_KANTOR_AUDITOR			VARCHAR(64)            not null,
   PROVINSI_KANTOR_AUDITOR		VARCHAR(64)            not null,
   KOORDINAT_KANTOR_AUDITOR		VARCHAR(64),
   TELEPHONE_KANTOR_AUDITOR		VARCHAR(16),
   FAXIMILE_KANTOR_AUDITOR		VARCHAR(16),
   KD_PARENT				BIGINT,
   STATUS_KANTOR_AUDITOR		CHAR(1)                not null
					constraint C_STATUS_KANTOR_AU check (STATUS_KANTOR_AUDITOR in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR),
   constraint F_EATKA_EAKA foreign key (KODE_TK_KANTOR_AUDITOR)
         references PAS_EA_TK_KANTOR_AUDITOR (KODE_TK_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAKA_EAKA foreign key (KD_PARENT)
         references PAS_EA_KANTOR_AUDITOR (KODE_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_EAKA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_KETUA_TIM_AUDITOR
--==============================================================
create table PAS_EA_KETUA_TIM_AUDITOR
(
   KODE_TK_KANTOR_AUDITOR		BIGINT                 not null,
   KODE_KANTOR_AUDITOR			BIGINT                 not null,
   KODE_USER_KETUA_TIM_AUDITOR		BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR, KODE_USER_KETUA_TIM_AUDITOR),
   constraint F_EAKA_EATA foreign key (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR)
         references PAS_EA_KANTOR_AUDITOR (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_EAKTA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_ANGGOTA_TIM_AUDITOR
--==============================================================
create table PAS_EA_ANGGOTA_TIM_AUDITOR
(
   KODE_TK_KANTOR_AUDITOR		BIGINT                 not null,
   KODE_KANTOR_AUDITOR			BIGINT                 not null,
   KODE_USER_KETUA_TIM_AUDITOR		BIGINT                 not null,
   KODE_USER_ANGGOTA_TIM_AUDITOR	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR, KODE_USER_KETUA_TIM_AUDITOR, KODE_USER_ANGGOTA_TIM_AUDITOR),
   constraint F_EATA_EAATA foreign key (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR, KODE_USER_KETUA_TIM_AUDITOR)
         references PAS_EA_KETUA_TIM_AUDITOR (KODE_TK_KANTOR_AUDITOR, KODE_KANTOR_AUDITOR, KODE_USER_KETUA_TIM_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_EAATA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_JENIS_PEMERIKSAAN
--==============================================================
create table PAS_EA_JENIS_PEMERIKSAAN
(
   KODE_JENIS_PEMERIKSAAN		CHAR(2)                not null
					constraint C_KODE_JENIS_PEMER check (KODE_JENIS_PEMERIKSAAN in ('AO','AI','AT','TI')),
   NAMA_JENIS_PEMERIKSAAN		VARCHAR(64)            not null,
   KETERANGAN_JENIS_PEMERIKSAAN		VARCHAR(256),
   STATUS_JENIS_PEMERIKSAAN		CHAR(1)                not null
					constraint C_STATUS_JENIS_PEM check (STATUS_JENIS_PEMERIKSAAN in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_JENIS_PEMERIKSAAN),
   constraint F_EAU_EAJP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_ASPEK_PEMERIKSAAN
--==============================================================
create table PAS_EA_ASPEK_PEMERIKSAAN
(
   KODE_JENIS_PEMERIKSAAN		CHAR(2)                not null,
   KODE_ASPEK_PEMERIKSAAN		VARCHAR(8)             not null unique,
   NAMA_ASPEK_PEMERIKSAAN		VARCHAR(64)            not null,
   KETERANGAN_ASPEK_PEMERIKSAAN		VARCHAR(256),
   TUJUAN_ASPEK_PEMERIKSAAN		VARCHAR(256)           not null,
   KD_PARENT				VARCHAR(8)             not null,
   STATUS_ASPEK_PEMERIKSAAN		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN),
   constraint F_EAJP_EAAP foreign key (KODE_JENIS_PEMERIKSAAN)
         references PAS_EA_JENIS_PEMERIKSAAN (KODE_JENIS_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_EAAP_EAAP foreign key (KD_PARENT)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_EAU_EAAP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_TK_AUDITAN
--==============================================================
create table PAS_EA_TK_AUDITAN
(
   KODE_TK_AUDITAN			BIGINT                 not null
					generated always as identity,
   NAMA_TK_AUDITAN			VARCHAR(64)            not null,
   KETERANGAN_TK_AUDITAN		VARCHAR(256),
   TK_AUDITAN				BIGINT                 not null,
   STATUS_TK_AUDITAN			CHAR(1)                not null
					constraint C_STATUS_TK_AUDITA check (STATUS_TK_AUDITAN in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_AUDITAN),
   constraint F_EAU_EATKA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_AUDITAN
--==============================================================
create table PAS_EA_AUDITAN
(
   KODE_TK_AUDITAN			BIGINT                 not null,
   KODE_AUDITAN				BIGINT                 not null unique
					generated always as identity,
   NAMA_AUDITAN				VARCHAR(64)            not null,
   ALAMAT_AUDITAN			VARCHAR(128)           not null,
   KOTA_AUDITAN				VARCHAR(64)            not null,
   PROVINSI_AUDITAN			VARCHAR(64)            not null,
   KOORDINAT_AUDITAN			VARCHAR(64),
   TELEPHONE_AUDITAN			VARCHAR(16),
   FAXIMILE_AUDITAN			VARCHAR(16),
   KD_PARENT				BIGINT                 not null,
   USERNAME_PIC_TL			VARCHAR(32)            not null,
   PASSWORD_PIC_TL			VARCHAR(32)            not null,
   NIK_PIC_TL				VARCHAR(8)             not null,
   NAMA_PIC_TL				VARCHAR(64)            not null,
   NO_HP_PIC_TL				VARCHAR(16)            not null,
   EMAIL_PIC_TL				VARCHAR(64)            not null,
   STATUS_AUDITAN			CHAR(1)                not null
					constraint C_STATUS_AUDITAN check (STATUS_AUDITAN in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_AUDITAN, KODE_AUDITAN),
   constraint F_EATA_EAA foreign key (KODE_TK_AUDITAN)
         references PAS_EA_TK_AUDITAN (KODE_TK_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAA_EAA foreign key (KD_PARENT)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_EAA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_FORMASI_AUDITAN
--==============================================================
create table PAS_EA_FORMASI_AUDITAN
(
   KODE_TK_AUDITAN			BIGINT                 not null,
   KODE_AUDITAN				BIGINT                 not null,
   KODE_FORMASI_AUDITAN			BIGINT                 not null
					generated always as identity,
   JABATAN				VARCHAR(64)            not null,
   GRADE				SMALLINT               not null,
   NIK					VARCHAR(8)             not null,
   NAMA					VARCHAR(64)            not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_AUDITAN, KODE_AUDITAN, KODE_FORMASI_AUDITAN),
   constraint F_EAA_EAFA foreign key (KODE_TK_AUDITAN, KODE_AUDITAN)
         references PAS_EA_AUDITAN (KODE_TK_AUDITAN, KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_EAFA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_TK_RISIKO
--==============================================================
create table PAS_KS_TK_RISIKO
(
   KODE_TK_RISIKO			BIGINT                 not null
					generated always as identity,
   NAMA_TK_RISIKO			VARCHAR(64)            not null,
   TK_RISIKO				SMALLINT               not null,
   NILAI_BAWAH				DECIMAL(5,2)           not null,
   NILAI_ATAS				DECIMAL(5,2)           not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_RISIKO),
   constraint F_EAU_KSTKR foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_EA_PROSEDUR_PEMERIKSAAN
--==============================================================
create table PAS_EA_PROSEDUR_PEMERIKSAAN
(
   KODE_JENIS_PEMERIKSAAN		CHAR(2)                not null,
   KODE_ASPEK_PEMERIKSAAN		VARCHAR(8)             not null,
   KODE_PEMERIKSAAN			BIGINT                 not null
					generated always as identity,
   CARA_PEMERIKSAAN			VARCHAR(256)           not null,
   KRITERIA				VARCHAR(256),
   PETUNJUK_PEMERIKSAAN			VARCHAR(256),
   NAMA_FILE_TEMPLATE_KKP		VARCHAR(64),
   FILE_TEMPLATE_KKP			LONG VARGRAPHIC,
   TK_RISIKO_ASPEK_TERPERIKSA		BIGINT,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN, KODE_PEMERIKSAAN),
   constraint F_EAA_EAPP foreign key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_KSTKR_EAPP foreign key (TK_RISIKO_ASPEK_TERPERIKSA)
         references PAS_KS_TK_RISIKO (KODE_TK_RISIKO)
         on delete restrict on update restrict,
   constraint F_EAU_EAPP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_AUDIT_TRAIL
--==============================================================
create table PAS_KS_AUDIT_TRAIL
(
   KODE_AUDIT_TRAIL			BIGINT                 not null
					generated always as identity,
   NAMA_TABEL				VARCHAR(32)            not null,
   KODE_RECORD				BIGINT                 not null,
   AKSI					VARCHAR(1024)          not null,
   ALAMAT_IP				VARCHAR(16)            not null,
   NAMA_KOMPUTER			VARCHAR(64)            not null,
   WAKTU				TIMESTAMP              not null,
   KODE_USER_PELAKU			BIGINT                 not null,
   constraint P_KEY_1 primary key (KODE_AUDIT_TRAIL),
   constraint F_EAU_KSAT foreign key (KODE_USER_PELAKU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_BOBOT_RI_PI
--==============================================================
create table PAS_KS_BOBOT_RI_PI
(
   KODE_BOBOT_RI_PI			BIGINT                 not null,
   BOBOT_RI				DECIMAL(3,2),
   BOBOT_PI				DECIMAL(3,2),
   KETERANGAN_BOBOT_RI_PI		VARCHAR(256),
   STATUS_BOBOT_RI_PI			CHAR(1),
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_KEY_1 primary key (KODE_BOBOT_RI_PI),
   constraint F_EAU_KSBRIPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_HAK_AKSES_ARSIP
--==============================================================
create table PAS_KS_HAK_AKSES_ARSIP
(
   KODE_HAK_AKSES_ARSIP			BIGINT                 not null
					generated always as identity,
   KODE_USER_PENGAKSES			BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_HAK_AKSES_ARSIP),
   constraint F_EAU_KSHAA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_HAK_AKSES_DATA
--==============================================================
create table PAS_KS_HAK_AKSES_DATA
(
   KODE_USERGROUP			BIGINT                 not null,
   DATA_PROSES_PEMERIKSAAN		CHAR(2)                not null,
   DATA_BUKTI_PEMERIKSAAN		CHAR(2)                not null,
   DATA_ADM_PEMERIKSAAN			CHAR(2)                not null,
   DATA_TEMUAN_AUDIT_INTERN		CHAR(2)                not null,
   DATA_LHP_AUDIT_INTERN		CHAR(2)                not null,
   DATA_TL_TEMUAN_AUDIT_INTERN		CHAR(2)                not null,
   DATA_KASUS_PELANGGARAN		CHAR(2)                not null,
   DATA_LHP_PELANGGARAN			CHAR(2)                not null,
   DATA_TL_KASUS_PELANGGARAN		CHAR(2)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERGROUP),
   constraint F_EAUG_KSHAD foreign key (KODE_USERGROUP)
         references PAS_EA_USERGROUP (KODE_USERGROUP)
         on delete restrict on update restrict,
   constraint F_EAU_KSHAD foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_HAK_AKSES_MENU
--==============================================================
create table PAS_KS_HAK_AKSES_MENU
(
   KODE_USERGROUP			BIGINT                 not null,
   KELOLA_AUDITAN			CHAR(1)                not null,
   KELOLA_AUDITOR			CHAR(1)                not null,
   KELOLA_ASPEK_PEMERIKSAAN		VARCHAR(1)             not null,
   KELOLA_PROSEDUR_PEMERIKSAAN		CHAR(1)                not null,
   KELOLA_PEMERIKSAAN_TAMBAHAN		CHAR(1)                not null,
   KELOLA_RKAP				CHAR(1)                not null,
   KELOLA_RKBPT				CHAR(1)                not null,
   KELOLA_PKPT				CHAR(1)                not null,
   PANTAU_PKPT				CHAR(1)                not null,
   KELOLA_RKPB				CHAR(1)                not null,
   KELOLA_PKPB				CHAR(1)                not null,
   PANTAU_PKPB				CHAR(1)                not null,
   MULAI_PROSES_PEMERIKSAAN		CHAR(1)                not null,
   KELOLA_PROSES_PEMERIKSAAN		CHAR(1)                not null,
   KELOLA_BUKTI_PEMERIKSAAN		CHAR(1)                not null,
   KELOLA_ADM_PEMERIKSAAN		CHAR(1)                not null,
   KELOLA_TEMUAN_AUDIT_INTERN		CHAR(1)                not null,
   KELOLA_LHP_AUDIT_INTERN		CHAR(1)                not null,
   KELOLA_LHP_KASUS_PELANGGARAN		CHAR(1)                not null,
   SELESAIKAN_PROSES_PEMERIKSAAN	CHAR(1)                not null,
   KELOLA_TEMUAN_AUDIT_EKSTERN		CHAR(1)                not null,
   PANTAU_RKPB_DAN_RKBPT		CHAR(1)                not null,
   PANTAU_RKAP				CHAR(1)                not null,
   KELOLA_TL_HASIL_AUDIT_INTERN		CHAR(1)                not null,
   KELOLA_TL_KASUS_PELANGGARAN		CHAR(1)                not null,
   KELOLA_TL_HASIL_AUDIT_EKSTERN	CHAR(1)                not null,
   PENGGUNAAN_ARSIP_PEMERIKSAAN		CHAR(1)                not null,
   PENCARIAN_DI_ARSIP_PEMERIKSAAN	CHAR(1)                not null,
   PENJAMINAN_MUTU_PEMERIKSAAN		CHAR(1)                not null,
   PELAPORAN_KINERJA_SPI		CHAR(1)                not null,
   KELOLA_PUSTAKA_AUDIT			CHAR(1)                not null,
   PENGGUNAAN_PUSTAKA_AUDIT		CHAR(1)                not null,
   KELOLA_KELOMPOK_PENGGUNA		CHAR(1)                not null,
   KELOLA_PENGGUNA			CHAR(1)                not null,
   KELOLA_HAK_AKSES			CHAR(1)                not null,
   KELOLA_KODIFIKASI_DATA		CHAR(1)                not null,
   KELOLA_KONFIGURASI_SISTEM		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERGROUP),
   constraint F_EAUG_KSHAM foreign key (KODE_USERGROUP)
         references PAS_EA_USERGROUP (KODE_USERGROUP)
         on delete restrict on update restrict,
   constraint F_EAU_KSHAM foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_HARI_LIBUR
--==============================================================
create table PAS_KS_HARI_LIBUR
(
   KODE_HARI_LIBUR			BIGINT                 not null
					generated always as identity,
   TANGGAL_HARI_LIBUR			DATE                   not null,
   KETERANGAN_HARI_LIBUR		VARCHAR(64)            not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_HARI_LIBUR),
   constraint F_EAU_KSHL foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_KODIFIKASI_BIDANG_KASUS
--==============================================================
create table PAS_KS_KODIFIKASI_BIDANG_KASUS
(
   KODE_BIDANG_KASUS			BIGINT                 not null
					generated always as identity,
   NAMA_BIDANG_KASUS			VARCHAR(128)           not null,
   STATUS_KODE				CHAR(1)                not null
					constraint C_STATUS_KODE check (STATUS_KODE in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_BIDANG_KASUS),
   constraint F_EAU_KSKBK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_KODIFIKASI_KASUS
--==============================================================
create table PAS_KS_KODIFIKASI_KASUS
(
   KODE_KASUS				BIGINT                 not null
					generated always as identity,
   NAMA_KASUS				VARCHAR(128)           not null,
   STATUS_KODE				CHAR(1)                not null
					constraint C_STATUS_KODE check (STATUS_KODE in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_KASUS),
   constraint F_EAU_KSKK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_KODIFIKASI_SEBAB
--==============================================================
create table PAS_KS_KODIFIKASI_SEBAB
(
   KODE_SEBAB				BIGINT                 not null
					generated always as identity,
   NAMA_SEBAB				VARCHAR(128)           not null,
   STATUS_KODE				CHAR(1)                not null
					constraint C_STATUS_KODE check (STATUS_KODE in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_SEBAB),
   constraint F_EAU_KSKS foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_KODIFIKASI_TEMUAN
--==============================================================
create table PAS_KS_KODIFIKASI_TEMUAN
(
   KODE_JENIS_PEMERIKSAAN		CHAR(2)                not null,
   KODE_ASPEK_PEMERIKSAAN		VARCHAR(8)             not null,
   KODE_TEMUAN				VARCHAR(8)             not null unique,
   NAMA_TEMUAN				VARCHAR(128)           not null,
   KD_PARENT				VARCHAR(8)             not null
					constraint C_KD_PARENT check (KD_PARENT in ('H','D')),
   STATUS_KODE				CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN, KODE_TEMUAN),
   constraint F_EAAP_KSKT foreign key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_KSKT_KSKT foreign key (KD_PARENT)
         references PAS_KS_KODIFIKASI_TEMUAN (KODE_TEMUAN)
         on delete restrict on update restrict,
   constraint F_EAU_KSKT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_KODIFIKASI_TK_TEMUAN
--==============================================================
create table PAS_KS_KODIFIKASI_TK_TEMUAN
(
   KODE_TK_TEMUAN			BIGINT                 not null
					generated always as identity,
   NAMA_TK_TEMUAN			VARCHAR(128)           not null,
   STATUS_KODE				CHAR(1)                not null
					constraint C_STATUS_KODE check (STATUS_KODE in ('A','P','X')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_TEMUAN),
   constraint F_EAU_KSKTKT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PARAMETER_MARA_PI
--==============================================================
create table PAS_KS_PARAMETER_MARA_PI
(
   KODE_PARAMETER_MARA_PI		BIGINT                 not null
					generated always as identity,
   PARAMETER_MARA_PI			VARCHAR(64)            not null,
   BOBOT_PARAMETER_MARA_PI		DECIMAL(3,2)           not null
					constraint C_BOBOT_PARAMETER_ check (BOBOT_PARAMETER_MARA_PI between 0 and 1),
   STATUS_PARAMETER_MARA_PI		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PARAMETER_MARA_PI),
   constraint F_EAU_KSPMARAPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PARAMETER_MARA_RI
--==============================================================
create table PAS_KS_PARAMETER_MARA_RI
(
   KODE_PARAMETER_MARA_RI		BIGINT                 not null
					generated always as identity,
   PARAMETER_MARA_RI			VARCHAR(64)            not null,
   BOBOT_PARAMETER_MARA_RI		DECIMAL(3,2)           not null
					constraint C_BOBOT_PARAMETER_ check (BOBOT_PARAMETER_MARA_RI between 0 and 1),
   STATUS_PARAMETER_MARA_RI		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PARAMETER_MARA_RI),
   constraint F_EAU_KSPMARARI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PARAMETER_MIRA_PI
--==============================================================
create table PAS_KS_PARAMETER_MIRA_PI
(
   KODE_PARAMETER_MIRA_PI		BIGINT                 not null
					generated always as identity,
   PARAMETER_MIRA_PI			VARCHAR(64)            not null,
   BOBOT_PARAMETER_MIRA_PI		DECIMAL(3,2)           not null
					constraint C_BOBOT_PARAMETER_ check (BOBOT_PARAMETER_MIRA_PI between 0 and 1),
   STATUS_PARAMETER_MIRA_PI		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PARAMETER_MIRA_PI),
   constraint F_EAU_KSPMIRAPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PARAMETER_MIRA_RI
--==============================================================
create table PAS_KS_PARAMETER_MIRA_RI
(
   KODE_PARAMETER_MIRA_RI		BIGINT                 not null
					generated always as identity,
   PARAMETER_MIRA_RI			VARCHAR(64)            not null,
   BOBOT_PARAMETER_MIRA_RI		DECIMAL(3,2)           not null
					constraint C_BOBOT_PARAMETER_ check (BOBOT_PARAMETER_MIRA_RI between 0 and 1),
   STATUS_PARAMETER_MIRA_RI		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PARAMETER_MIRA_RI),
   constraint F_EAU_KSPMIRARI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PERIODE_INPUT_STANDAR
--==============================================================
create table PAS_KS_PERIODE_INPUT_STANDAR
(
   KODE_PERIODE_INPUT_STANDAR		BIGINT                 not null
					generated always as identity,
   TGL_AWAL_INPUT_DATA_TAHUNAN		SMALLINT               not null,
   BLN_AWAL_INPUT_DATA_TAHUNAN		SMALLINT               not null,
   TGL_AKHIR_INPUT_DATA_TAHUNAN		SMALLINT               not null,
   BLN_AKHIR_INPUT_DATA_TAHUNAN		SMALLINT               not null,
   TGL_AKHIR_INPUT_DATA_BULANAN		SMALLINT               not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_KEY_1 primary key (KODE_PERIODE_INPUT_STANDAR),
   constraint F_EAU_KSPIS foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_PERIODE_INPUT_TAMBAHAN
--==============================================================
create table PAS_KS_PERIODE_INPUT_TAMBAHAN
(
   KODE_PERIODE_INPUT_TAMBAHAN		BIGINT                 not null
					generated always as identity,
   KODE_PEMILIK				BIGINT                 not null,
   TIPE_PEMILIK				CHAR(1)                not null
					constraint C_TIPE_PEMILIK check (TIPE_PEMILIK in ('A','I')),
   TGL_AKHIR_INPUT_DATA_TAHUNAN		DATE                   not null,
   TGL_AKHIR_INPUT_DATA_BULANAN		DATE                   not null,
   STATUS_PERIODE_INPUT_TAMBAHAN	CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PERIODE_INPUT_TAMBAHAN),
   constraint F_EAU_KSPIT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_TK_KESIMPULAN
--==============================================================
create table PAS_KS_TK_KESIMPULAN
(
   KODE_TK_KESIMPULAN			BIGINT                 not null
					generated always as identity,
   NAMA_TK_KESIMPULAN			VARCHAR(64)            not null,
   TK_KESIMPULAN			SMALLINT               not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TK_KESIMPULAN),
   constraint F_EAU_KSTKK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_KS_USERNAME_PASSWORD
--==============================================================
create table PAS_KS_USERNAME_PASSWORD
(
   KODE_USERNAME_PASSWORD		BIGINT                 not null
					generated always as identity,
   MIN_PANJANG_USERNAME			SMALLINT               not null,
   MIN_PANJANG_PASSWORD			SMALLINT               not null,
   ADA_HURUF_KAPITAL			CHAR(1)                not null,
   ADA_HURUF_KECIL			CHAR(1)                not null,
   ADA_ANGKA				CHAR(1)                not null,
   ADA_TANDA_BACA			CHAR(1)                not null,
   BOLEH_BERULANG			SMALLINT               not null,
   USIA_PASSWORD			SMALLINT               not null,
   MAX_SALAH_INPUT_PASSWORD		SMALLINT               not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_USERNAME_PASSWORD),
   constraint F_EAU_KSUP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict

);

--==============================================================
-- Table: PAS_LP_AUDITOR_EKSTERN
--==============================================================
create table PAS_LP_AUDITOR_EKSTERN
(
   KODE_AUDITOR_EKSTERN			BIGINT                 not null
					generated always as identity,
   NAMA_AUDITOR_EKSTERN			VARCHAR(64)            not null,
   ALAMAT_AUDITOR_EKSTERN		VARCHAR(128)           not null,
   KOTA_AUDITOR_ESKTERN			VARCHAR(64)            not null,
   PROVINSI_AUDITOR_EKSTERN		VARCHAR(64)            not null,
   NOMOR_TELEPHONE			VARCHAR(16)            not null,
   NOMOR_FAXIMILE			VARCHAR(16),
   NAMA_CONTACT_PERSON			VARCHAR(64),
   JABATAN_CONTACT_PERSON		VARCHAR(64),
   HP_CONTACT_PERSON			VARCHAR(16),
   EMAIL_CONTACT_PERSOM			VARCHAR(64),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_AUDITOR_EKSTERN),
   constraint F_EAU_LPAE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_PKPT
--==============================================================
create table PAS_RA_PKPT
(
   KODE_PKPT				BIGINT                 not null
					generated always as identity,
   KODE_PKPT_YANG_DIREVISI		BIGINT,
   TAHUN_PKPT				BIGINT                 not null,
   KODE_KANTOR_AUDITOR_PEMILIK		BIGINT,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   STATUS_PEMBUATAN			CHAR(2)                not null
					constraint C_STATUS_PEMBUATAN check (STATUS_PEMBUATAN in ('BS','SS')),
   NOMOR_SURAT_PENGAJUAN		VARCHAR(32),
   TANGGAL_SURAT_PENGAJUAN		DATE,
   KODE_USER_PEREVIU			BIGINT,
   STATUS_REVIU				CHAR(2)               
					constraint C_STATUS_REVIU check (STATUS_REVIU is null or (STATUS_REVIU in ('BR','SR'))),
   KODE_USER_PENYETUJU			BIGINT,
   STATUS_PERSETUJUAN			CHAR(2)               
					constraint C_STATUS_PERSETUJU check (STATUS_PERSETUJUAN is null or (STATUS_PERSETUJUAN in ('BS','SS'))),
   NOMOR_SURAT_PERSETUJUAN		VARCHAR(32),
   TANGGAL_SURAT_PERSETUJUAN		DATE,
   STATUS_PKPT				CHAR(1)                not null
					constraint C_STATUS_PKPT check (STATUS_PKPT in ('R','A')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT),
   constraint F_RAPKPT_RAPKPT foreign key (KODE_PKPT_YANG_DIREVISI)
         references PAS_RA_PKPT (KODE_PKPT)
         on delete restrict on update restrict,
   constraint F_EAKA_RAPKPT foreign key (KODE_KANTOR_AUDITOR_PEMILIK)
         references PAS_EA_KANTOR_AUDITOR (KODE_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_RAPKPT_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAPKPT_REVIU foreign key (KODE_USER_PEREVIU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAPKPT_SETUJU foreign key (KODE_USER_PENYETUJU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAPKPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_PKPB
--==============================================================
create table PAS_SA_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null
					generated always as identity,
   BULAN_PKPB				BIGINT                 not null,
   KODE_KANTOR_AUDITOR_PEMILIK		BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT,
   STATUS_PEMBUATAN			CHAR(2)               
					constraint C_STATUS_PEMBUATAN check (STATUS_PEMBUATAN is null or (STATUS_PEMBUATAN in ('BS','SS'))),
   NOMOR_SURAT_PENGAJUAN		VARCHAR(32),
   TANGGAL_SURAT_PENGAJUAN		DATE,
   KODE_USER_PEREVIU			BIGINT,
   STATUS_REVIU				CHAR(2)               
					constraint C_STATUS_REVIU check (STATUS_REVIU is null or (STATUS_REVIU in ('BR','SR'))),
   KODE_USER_PENYETUJU			BIGINT,
   STATUS_PERSETUJUAN			CHAR(2)               
					constraint C_STATUS_PERSETUJU check (STATUS_PERSETUJUAN is null or (STATUS_PERSETUJUAN in ('BS','SS'))),
   NOMOR_SURAT_PERSETUJUAN		VARCHAR(32),
   TANGGAL_SURAT_PERSETUJUAN		DATE,
   STATUS_PKPB				CHAR(1)               
					constraint C_STATUS_PKPB check (STATUS_PKPB is null or (STATUS_PKPB in ('R','A'))),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB),
   constraint F_RAPKPT_SAMPKPB foreign key (KODE_PKPT)
         references PAS_RA_PKPT (KODE_PKPT)
         on delete restrict on update restrict,
   constraint F_EAKA_SAPKPB foreign key (KODE_KANTOR_AUDITOR_PEMILIK)
         references PAS_EA_KANTOR_AUDITOR (KODE_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_SAPKPB_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAPKPB_REVIU foreign key (KODE_USER_PEREVIU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAPKPB_SETUJU foreign key (KODE_USER_PENYETUJU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_REALISASI_KEGIATAN_PKPB
--==============================================================
create table PAS_PP_REALISASI_KEGIATAN_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL_KEGIATAN		DATE                   not null,
   TANGGAL_AKHIR_KEGIATAN		DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null,
   KETERANGAN_KEGIATAN			VARCHAR(256),
   STATUS_INAP				CHAR(2)                not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null,
   BIAYA_TRANSPORTASI			BIGINT                 not null,
   BIAYA_MOBIL_DINAS			BIGINT                 not null,
   BIAYA_LUMPSUM			BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   ALASAN_TIDAK_SESUAI_RENCANA		VARCHAR(256),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB),
   constraint F_SAPKPB_PPRKPKPB foreign key (KODE_PKPT, KODE_PKPB)
         references PAS_SA_PKPB (KODE_PKPT, KODE_PKPB)
         on delete restrict on update restrict,
   constraint F_EAU_PPRKPKPB_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPRKPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_PKPI
--==============================================================
create table PAS_PP_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null
					generated always as identity,
   KODE_AUDITAN_PKPI			BIGINT                 not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null
					constraint C_NAMA_KEGIATAN check (NAMA_KEGIATAN in ('AM','AP','AI','AT','TI')),
   STATUS_INAP				CHAR(2)                not null,
   KODE_USER_KOORDINATOR_AUDITOR	BIGINT,
   KODE_USER_KETUA_AUDITOR		BIGINT                 not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   STATUS_PROSES_PEMERIKSAAN		CHAR(2)                not null
					constraint C_STATUS_PROSES_PE check (STATUS_PROSES_PEMERIKSAAN in ('BS','SS')),
   STATUS_PROSES_TEMUAN			CHAR(2)                not null
					constraint C_STATUS_PROSES_TE check (STATUS_PROSES_TEMUAN in ('BS','SS')),
   STATUS_PROSES_LAPORAN		CHAR(2)                not null
					constraint C_STATUS_PROSES_LA check (STATUS_PROSES_LAPORAN in ('BS','SS')),
   STATUS_PROSES_TINDAK_LANJUT		CHAR(2)                not null,
   STATUS_PKPI				CHAR(1)                not null
					constraint C_STATUS_PKPI check (STATUS_PKPI in ('T','A')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI),
   constraint F_PPRKPKPB_PPPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB)
         references PAS_PP_REALISASI_KEGIATAN_PKPB (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB)
         on delete restrict on update restrict,
   constraint F_EAA_PPPKPI foreign key (KODE_AUDITAN_PKPI)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_PPPKPI_KOORD foreign key (KODE_USER_KOORDINATOR_AUDITOR)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPKPI_KETUA foreign key (KODE_USER_KETUA_AUDITOR)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_LHA
--==============================================================
create table PAS_LP_LHA
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_LHA				VARCHAR(32)            not null,
   TANGGAL_LHA				DATE                   not null,
   NAMA_FILE_LHA			VARCHAR(64)            not null,
   FILE_LHA				LONG VARGRAPHIC        not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHA),
   constraint F_PPPKPI_LPLHA foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_LPLHA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_LHA_EKSTERN
--==============================================================
create table PAS_LP_LHA_EKSTERN
(
   KODE_AUDITOR_EKSTERN			BIGINT                 not null,
   NOMOR_LHA_EKSTERN			VARCHAR(64)            not null,
   TANGGAL_LHA_EKSTERN			DATE                   not null,
   TAHUN_PERIODE_AUDIT			BIGINT                 not null,
   NAME_FILE_LHA_EKSTERN		VARCHAR(64)            not null,
   FILE_LHA_EKSTERN			LONG VARGRAPHIC        not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN),
   constraint F_LPAE_LPLHAE foreign key (KODE_AUDITOR_EKSTERN)
         references PAS_LP_AUDITOR_EKSTERN (KODE_AUDITOR_EKSTERN)
         on delete restrict on update restrict,
   constraint F_EAU_LPLHAE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_LHPP
--==============================================================
create table PAS_LP_LHPP
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_LHPP				VARCHAR(32)            not null unique,
   TANGGAL_LHPP				DATE                   not null,
   NAMA_FILE_LHPP			VARCHAR(64)            not null,
   FILE_LHPP				LONG VARGRAPHIC        not null,
   TEMPAT_KEJADIAN			VARCHAR(64)            not null,
   TANGGAL_KEJADIAN			DATE                   not null,
   JUMLAH_KERUGIAN_POTENSIAL		BIGINT                 not null,
   JUMLAH_KERUGIAN_RIIL			BIGINT                 not null,
   DESKRIPSI_KASUS			VARCHAR(1024)          not null,
   KODE_KASUS				BIGINT,
   KODE_BIDANG_KASUS			BIGINT                 not null,
   NOMOR_LHPP_LAMA			VARCHAR(32),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP),
   constraint F_PPMPKPI_LPLHPP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_KSKK_LPLHPP foreign key (KODE_KASUS)
         references PAS_KS_KODIFIKASI_KASUS (KODE_KASUS)
         on delete restrict on update restrict,
   constraint F_KSKBK_LPLHPP foreign key (KODE_BIDANG_KASUS)
         references PAS_KS_KODIFIKASI_BIDANG_KASUS (KODE_BIDANG_KASUS)
         on delete restrict on update restrict,
   constraint F_LPLHPP_LPLHPP foreign key (NOMOR_LHPP_LAMA)
         references PAS_LP_LHPP (NOMOR_LHPP)
         on delete restrict on update restrict,
   constraint F_EAU_LPLHPP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_PELAKU_PELANGGARAN
--==============================================================
create table PAS_LP_PELAKU_PELANGGARAN
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_LHPP				VARCHAR(32)            not null,
   NIK_PELAKU				VARCHAR(8)             not null,
   NAMA_PELAKU				VARCHAR(64)            not null,
   JABATAN_PELAKU			VARCHAR(64)            not null,
   GRADE				SMALLINT               not null,
   UNIT_KERJA_PELAKU			VARCHAR(64)            not null,
   PELANGGARAN				VARCHAR(1024)          not null,
   USULAN_SANKSI			VARCHAR(1024)          not null,
   USULAN_TGR				BIGINT                 not null,
   STATUS_PENYELESAIAN			CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP, NIK_PELAKU),
   constraint F_LPLHPP_LPPP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP)
         references PAS_LP_LHPP (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP)
         on delete restrict on update restrict,
   constraint F_EAU_LPPP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_PENYELESAIAN_KERUGIAN
--==============================================================
create table PAS_LP_PENYELESAIAN_KERUGIAN
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_LHPP				VARCHAR(32)            not null,
   KODE_PENYELESAIAN_KERUGIAN		BIGINT                 not null
					generated always as identity,
   TANGGAL_PENYELESAIAN_KERUGIAN	DATE                   not null,
   NOMINAL_PENYELESAIAN_KERUGIAN	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP, KODE_PENYELESAIAN_KERUGIAN),
   constraint F_LPLHPP_LPPK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP)
         references PAS_LP_LHPP (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP)
         on delete restrict on update restrict,
   constraint F_EAU_LPPK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_RKBPT
--==============================================================
create table PAS_RA_RKBPT
(
   KODE_RKBPT				BIGINT                 not null
					generated always as identity,
   KODE_RKBPT_YANG_DIREVISI		BIGINT,
   TAHUN_RKBPT				BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   STATUS_PEMBUATAN			CHAR(2),
   NOMOR_SURAT_PENGAJUAN		VARCHAR(32),
   TANGGAL_SURAT_PENGAJUAN		DATE,
   KODE_USER_PENYETUJU			BIGINT,
   STATUS_PERSETUJUAN			CHAR(2),
   NOMOR_SURAT_PERSETUJUAN		VARCHAR(32),
   TANGGAL_SURAT_PERSETUJUAN		DATE,
   STATUS_RKBPT				CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_RKBPT),
   constraint F_RARKBPT_RARKBPT foreign key (KODE_RKBPT_YANG_DIREVISI)
         references PAS_RA_RKBPT (KODE_RKBPT)
         on delete restrict on update restrict,
   constraint F_EAU_RARKBPT_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RARKBPT_SETUJU foreign key (KODE_USER_PENYETUJU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RARKBPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_RKPB
--==============================================================
create table PAS_SA_RKPB
(
   KODE_RKBPT				BIGINT                 not null,
   KODE_RKPB				BIGINT                 not null
					generated always as identity,
   BULAN_RKPB				BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   STATUS_PEMBUATAN			CHAR(2)               
					constraint C_STATUS_PEMBUATAN check (STATUS_PEMBUATAN is null or (STATUS_PEMBUATAN in ('BS','SS'))),
   NOMOR_SURAT_PENGAJUAN		VARCHAR(32),
   TANGGAL_SURAT_PENGAJUAN		DATE,
   KODE_USER_PENYETUJU			BIGINT,
   STATUS_PERSETUJUAN			CHAR(2)               
					constraint C_STATUS_PERSETUJU check (STATUS_PERSETUJUAN is null or (STATUS_PERSETUJUAN in ('BS','SS'))),
   NOMOR_SURAT_PERSETUJUAN		VARCHAR(32),
   TANGGAL_SURAT_PERSETUJUAN		DATE,
   STATUS_RKPB				CHAR(1)                not null
					constraint C_STATUS_RKPB check (STATUS_RKPB in ('R','A')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_RKBPT, KODE_RKPB),
   constraint F_RARKBPT_SARKPB foreign key (KODE_RKBPT)
         references PAS_RA_RKBPT (KODE_RKBPT)
         on delete restrict on update restrict,
   constraint F_EAU_SARKPB_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SARKPB_SETUJU foreign key (KODE_USER_PENYETUJU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SARKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_REALISASI_KEGIATAN_RKPB
--==============================================================
create table PAS_LP_REALISASI_KEGIATAN_RKPB
(
   KODE_RKBPT				BIGINT                 not null,
   KODE_RKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_RKPB		BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL				DATE                   not null,
   TANGGAL_AKHIR			DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null,
   TEMPAT_KEGIATAN			VARCHAR(256)           not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   KETERANGAN_KEGIATAN			VARCHAR(256)           not null
					constraint C_KETERANGAN_KEGIA check (KETERANGAN_KEGIATAN in ('PP','IN','PJ')),
   JARAK				BIGINT                 not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null
					constraint C_JENIS_TRANSPORTA check (JENIS_TRANSPORTASI in ('MD','KU')),
   BIAYA_TRANSPORTASI			BIGINT                 not null
					constraint C_BIAYA_TRANSPORTA check (BIAYA_TRANSPORTASI >= 0),
   BIAYA_LUMPSUM			BIGINT                 not null
					constraint C_BIAYA_LUMPSUM check (BIAYA_LUMPSUM >= 0),
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_RKBPT, KODE_RKPB, KODE_REALISASI_KEGIATAN_RKPB),
   constraint F_SARKPB_LPRKRKPB foreign key (KODE_RKBPT, KODE_RKPB)
         references PAS_SA_RKPB (KODE_RKBPT, KODE_RKPB)
         on delete restrict on update restrict,
   constraint F_EAU_LPRKRKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_MASTER_RKAP
--==============================================================
create table PAS_RA_MASTER_RKAP
(
   KODE_RKAP				BIGINT                 not null
					generated always as identity,
   KODE_RKAP_YANG_DIREVISI		BIGINT,
   TAHUN_RKAP				BIGINT                 not null,
   KODE_KANTOR_AUDITOR_PEMILIK		BIGINT,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   STATUS_PEMBUATAN			CHAR(2)               
					constraint C_STATUS_PEMBUATAN check (STATUS_PEMBUATAN is null or (STATUS_PEMBUATAN in ('BS','SS'))),
   NOMOR_SURAT_PENGAJUAN		VARCHAR(32),
   TANGGAL_SURAT_PENGAJUAN		DATE,
   KODE_USER_PEREVIU			BIGINT,
   STATUS_REVIU				CHAR(2)               
					constraint C_STATUS_REVIU check (STATUS_REVIU is null or (STATUS_REVIU in ('BR','SR'))),
   KODE_USER_PENYETUJU			BIGINT,
   STATUS_PERSETUJUAN			CHAR(2)               
					constraint C_STATUS_PERSETUJU check (STATUS_PERSETUJUAN is null or (STATUS_PERSETUJUAN in ('BS','SS'))),
   NOMOR_SURAT_PERSETUJUAN		VARCHAR(32),
   TANGGAL_SURAT_PERSETUJUAN		DATE,
   STATUS_RKAP				CHAR(1)                not null
					constraint C_STATUS_RKAP check (STATUS_RKAP in ('R','A')),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_RKAP),
   constraint F_RAMRKAP_RAMRKAP foreign key (KODE_RKAP_YANG_DIREVISI)
         references PAS_RA_MASTER_RKAP (KODE_RKAP)
         on delete restrict on update restrict,
   constraint F_EAKA_RAMRKAP foreign key (KODE_KANTOR_AUDITOR_PEMILIK)
         references PAS_EA_KANTOR_AUDITOR (KODE_KANTOR_AUDITOR)
         on delete restrict on update restrict,
   constraint F_EAU_RAMRKAP_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAMRKAP_REVIU foreign key (KODE_USER_PEREVIU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAMRKAP_SETUJU foreign key (KODE_USER_PENYETUJU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAMRKAP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_DETAIL_RKAP
--==============================================================
create table PAS_RA_DETAIL_RKAP
(
   KODE_RKAP				BIGINT                 not null,
   KODE_MATA_ANGGARAN			VARCHAR(16)            not null,
   NAMA_MATA_ANGGARAN			VARCHAR(64)            not null,
   NOMINAL_MATA_ANGGARAN		BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_RKAP, KODE_MATA_ANGGARAN),
   constraint F_RAMRKAP_RADRKAP foreign key (KODE_RKAP)
         references PAS_RA_MASTER_RKAP (KODE_RKAP)
         on delete restrict on update restrict,
   constraint F_EAU_RADRKAP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_REALISASI_RKAP
--==============================================================
create table PAS_LP_REALISASI_RKAP
(
   KODE_RKAP				BIGINT                 not null,
   KODE_MATA_ANGGARAN			VARCHAR(16)            not null,
   KODE_TRANSAKSI			BIGINT                 not null
					generated always as identity,
   TANGGAL_TRANSAKSI			DATE                   not null,
   KETERANGAN_TRANSAKSI			VARCHAR(256)           not null,
   NOMINAL_TRANSAKSI			BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   NAMA_FILE_BUKTI_TRANSAKSI		VARCHAR(64)            not null,
   FILE_BUKTI_TRANSAKSI			LONG VARGRAPHIC        not null,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_RKAP, KODE_MATA_ANGGARAN, KODE_TRANSAKSI),
   constraint F_RARKAP_LPRRKAP foreign key (KODE_RKAP, KODE_MATA_ANGGARAN)
         references PAS_RA_DETAIL_RKAP (KODE_RKAP, KODE_MATA_ANGGARAN)
         on delete restrict on update restrict,
   constraint F_EAU_LPRRKAP_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_LPRRKAP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_TEMUAN_AUDIT_EKSTERN
--==============================================================
create table PAS_LP_TEMUAN_AUDIT_EKSTERN
(
   KODE_AUDITOR_EKSTERN			BIGINT                 not null,
   NOMOR_LHA_EKSTERN			VARCHAR(64)            not null,
   KODE_TEMUAN_AUDIT_EKSTERN		BIGINT                 not null
					generated always as identity,
   JUDUL_TEMUAN				VARCHAR(1024)          not null,
   KONDISI				VARCHAR(8192)          not null,
   KRITERIA				VARCHAR(256)           not null,
   SEBAB				VARCHAR(1024)          not null,
   AKIBAT				VARCHAR(1024)          not null,
   TANGGAPAN_AUDITAN			VARCHAR(1024)          not null,
   JANGKA_WAKTU_TINDAK_LANJUT		DATE                   not null,
   REKOMENDASI				VARCHAR(1024)          not null,
   POTENSI_KERUGIAN			BIGINT                 not null,
   KODE_AUDITAN_PENANGGUNG_JAWAB	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN),
   constraint F_LPLHAE_LPTAE foreign key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN)
         references PAS_LP_LHA_EKSTERN (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN)
         on delete restrict on update restrict,
   constraint F_EAA_LPTAE foreign key (KODE_AUDITAN_PENANGGUNG_JAWAB)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_LPTAE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_TEMUAN_AUDIT_INTERN
--==============================================================
create table PAS_LP_TEMUAN_AUDIT_INTERN
(
   KODE_TEMUAN_AUDIT_INTERN		BIGINT                 not null
					generated always as identity,
   JUDUL_TEMUAN				VARCHAR(1024)          not null,
   KODE_JENIS_PEMERIKSAAN		CHAR(2),
   KODE_ASPEK_PEMERIKSAAN		VARCHAR(8),
   KODE_TEMUAN				VARCHAR(8),
   KONDISI				VARCHAR(8192)          not null,
   KRITERIA				VARCHAR(256)           not null,
   SEBAB				VARCHAR(1024)          not null,
   KODE_SEBAB				BIGINT,
   AKIBAT				VARCHAR(1024)          not null,
   TANGGAPAN_AUDITAN			VARCHAR(1024)          not null,
   JANGKA_WAKTU_TINDAK_LANJUT		DATE                   not null,
   REKOMENDASI				VARCHAR(1024)          not null,
   KODE_TK_TEMUAN			SMALLINT               not null,
   POTENSI_KERUGIAN			BIGINT                 not null,
   KODE_AUDITAN_PENANGGUNG_JAWAB	BIGINT                 not null,
   STATUS_PENYELESAIAN			CHAR(1)                not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TEMUAN_AUDIT_INTERN),
   constraint F_KSKT_LPTAI foreign key (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN, KODE_TEMUAN)
         references PAS_KS_KODIFIKASI_TEMUAN (KODE_JENIS_PEMERIKSAAN, KODE_ASPEK_PEMERIKSAAN, KODE_TEMUAN)
         on delete restrict on update restrict,
   constraint F_KSKS_LPTAI foreign key (KODE_SEBAB)
         references PAS_KS_KODIFIKASI_SEBAB (KODE_SEBAB)
         on delete restrict on update restrict,
   constraint F_KSKTKT_LPTAI foreign key (KODE_TK_TEMUAN)
         references PAS_KS_KODIFIKASI_TK_TEMUAN (KODE_TK_TEMUAN)
         on delete restrict on update restrict,
   constraint F_EAA_LPTAI foreign key (KODE_AUDITAN_PENANGGUNG_JAWAB)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_LPTAI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_ASPEK_PEMERIKSAAN_PKPI
--==============================================================
create table PAS_PP_ASPEK_PEMERIKSAAN_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null unique
					generated always as identity,
   NAMA_ASPEK_PEMERIKSAAN		VARCHAR(64)            not null,
   KETERANGAN_ASPEK_PEMERIKSAAN		VARCHAR(256),
   TUJUAN_ASPEK_PEMERIKSAAN		VARCHAR(256),
   KD_PARENT				BIGINT                 not null,
   KESIMPULAN				VARCHAR(8192),
   KODE_TK_KESIMPULAN			BIGINT,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI),
   constraint F_PPMPKPI_PPAPPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_PPAPPKPI_PPAPPKPI foreign key (KD_PARENT)
         references PAS_PP_ASPEK_PEMERIKSAAN_PKPI (KODE_ASPEK_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_KSTKK_PPAPPKPI foreign key (KODE_TK_KESIMPULAN)
         references PAS_KS_TK_KESIMPULAN (KODE_TK_KESIMPULAN)
         on delete restrict on update restrict,
   constraint F_EAU_PPAPPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_PEMERIKSAAN_PKPI
--==============================================================
create table PAS_PP_PEMERIKSAAN_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_PEMERIKSAAN_PKPI		BIGINT                 not null
					generated always as identity,
   CARA_PEMERIKSAAN			VARCHAR(256)           not null,
   KRITERIA				VARCHAR(256),
   HASIL_PEMERIKSAAN			VARCHAR(8192),
   KODE_USER_PEMERIKSA			BIGINT,
   REVIU_PEMERIKSAAN			VARCHAR(8192),
   KODE_USER_PEREVIU			BIGINT,
   WAKTU_INSERT_CATATAN_REVIU		DATE,
   WAKTU_UPDATE_CATATAN_REVIU		DATE,
   STATUS_CARA_PEMERIKSAAN		CHAR(1)               
					constraint C_STATUS_CARA_PEME check (STATUS_CARA_PEMERIKSAAN is null or (STATUS_CARA_PEMERIKSAAN in ('S','B','T'))),
   STATUS_HASIL_PEMERIKSAAN		CHAR(1)               
					constraint C_STATUS_HASIL_PEM check (STATUS_HASIL_PEMERIKSAAN is null or (STATUS_HASIL_PEMERIKSAAN in ('B','T'))),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI),
   constraint F_PPAPPKPI_PPPP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         references PAS_PP_ASPEK_PEMERIKSAAN_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPPPKPI_PEMERIKSA foreign key (KODE_USER_PEMERIKSA)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPPKPI_PEREVIU foreign key (KODE_USER_PEREVIU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_LP_TEMUAN_PEMERIKSAAN
--==============================================================
create table PAS_LP_TEMUAN_PEMERIKSAAN
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_TEMUAN_AUDIT_INTERN		BIGINT                 not null,
   KODE_TEMUAN_PEMERIKSAAN		BIGINT                 not null
					generated always as identity,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI, KODE_TEMUAN_AUDIT_INTERN, KODE_TEMUAN_PEMERIKSAAN),
   constraint F_PPPP_LPTP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI)
         references PAS_PP_PEMERIKSAAN_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_LPTAI_LPTP foreign key (KODE_TEMUAN_AUDIT_INTERN)
         references PAS_LP_TEMUAN_AUDIT_INTERN (KODE_TEMUAN_AUDIT_INTERN)
         on delete restrict on update restrict,
   constraint F_EAU_LPTP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PA_KATEGORI_PUSTAKA
--==============================================================
create table PAS_PA_KATEGORI_PUSTAKA
(
   KODE_KATEGORI_PUSTAKA		BIGINT                 not null
					generated always as identity,
   NAMA_KATEGORI_PUSTAKA		VARCHAR(64)            not null,
   KETERANGAN_KATEGORI_PUSTAKA		VARCHAR(256)           not null,
   KD_PARENT				BIGINT                 not null,
   STATUS_KATEGORI_PUSTAKA		CHAR(1)                not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_KATEGORI_PUSTAKA),
   constraint F_PAKP_PAKP foreign key (KD_PARENT)
         references PAS_PA_KATEGORI_PUSTAKA (KODE_KATEGORI_PUSTAKA)
         on delete restrict on update restrict,
   constraint F_EAU_PAKP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PA_PUSTAKA
--==============================================================
create table PAS_PA_PUSTAKA
(
   KODE_KATEGORI_PUSTAKA		BIGINT                 not null,
   KODE_PUSTAKA				BIGINT                 not null
					generated always as identity,
   JUDUL_PUSTAKA			VARCHAR(64)            not null,
   KETERANGAN_PUSTAKA			VARCHAR(256),
   KATA_KUNCI_PUSTAKA			VARCHAR(1024),
   NAMA_FILE_PUSTAKA			VARCHAR(64)            not null,
   FILE_PUSTAKA				LONG VARGRAPHIC        not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_KATEGORI_PUSTAKA, KODE_PUSTAKA),
   constraint F_PAP_PAKP foreign key (KODE_KATEGORI_PUSTAKA)
         references PAS_PA_KATEGORI_PUSTAKA (KODE_KATEGORI_PUSTAKA)
         on delete restrict on update restrict,
   constraint F_EAU_PAP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PA_PUSTAKA_BELUM_TERBACA
--==============================================================
create table PAS_PA_PUSTAKA_BELUM_TERBACA
(
   KODE_KATEGORI_PUSTAKA		BIGINT                 not null,
   KODE_PUSTAKA				BIGINT                 not null,
   KODE_USER_PEMBACA_PUSTAKA		BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_KEY_1 primary key (KODE_KATEGORI_PUSTAKA, KODE_PUSTAKA, KODE_USER_PEMBACA_PUSTAKA),
   constraint F_PAP_PAPP foreign key (KODE_KATEGORI_PUSTAKA, KODE_PUSTAKA)
         references PAS_PA_PUSTAKA (KODE_KATEGORI_PUSTAKA, KODE_PUSTAKA)
         on delete restrict on update restrict,
   constraint F_EAU_PAPBT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_ANGGOTA_AUDITOR_PKPI
--==============================================================
create table PAS_PP_ANGGOTA_AUDITOR_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_USER_ANGGOTA_AUDITOR_PKPI	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_USER_ANGGOTA_AUDITOR_PKPI),
   constraint F_PPMPKPI_PPAAPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPAAPKPI_AGGTA foreign key (KODE_USER_ANGGOTA_AUDITOR_PKPI)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPAAPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_BUKTI_PEMERIKSAAN_PKPI
--==============================================================
create table PAS_PP_BUKTI_PEMERIKSAAN_PKPI
(
   KODE_BUKTI_PEMERIKSAAN_PKPI		BIGINT                 not null
					generated always as identity,
   KODE_PKPT				BIGINT,
   KODE_PKPB				BIGINT,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT,
   KODE_PKPI				BIGINT,
   NAMA_FILE_BUKTI_PEMERIKSAAN		VARCHAR(64)            not null,
   FILE_BUKTI_PEMERIKSAAN		LONG VARGRAPHIC        not null,
   KETERANGAN_BUKTI_PEMERIKSAAN		VARCHAR(256),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_BUKTI_PEMERIKSAAN_PKPI),
   constraint F_REFERENCE_66 foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPBPPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_BUKTI_HASIL_PEMERIKSAAN
--==============================================================
create table PAS_PP_BUKTI_HASIL_PEMERIKSAAN
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_BUKTI_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_BUKTI_HASIL_PEMERIKSAAN		BIGINT                 not null
					generated always as identity,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI, KODE_BUKTI_PEMERIKSAAN_PKPI, KODE_BUKTI_HASIL_PEMERIKSAAN),
   constraint F_PPPPKPI_PPBHP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI)
         references PAS_PP_PEMERIKSAAN_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_PPBP_PPBHP foreign key (KODE_BUKTI_PEMERIKSAAN_PKPI)
         references PAS_PP_BUKTI_PEMERIKSAAN_PKPI (KODE_BUKTI_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPBHP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_MASTER_BAPK
--==============================================================
create table PAS_PP_MASTER_BAPK
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_BAPK				VARCHAR(32)            not null,
   TANGGAL_BAPK				DATE                   not null,
   NAMA_TERPERIKSA			VARCHAR(64)            not null,
   NIK_TERPERIKSA			VARCHAR(8)             not null,
   JABATAN_TERPERIKSA			VARCHAR(64)            not null,
   UNIT_KERJA_TERPERIKSA		VARCHAR(64)            not null,
   STATUS_TERPERIKSA			CHAR(2)                not null,
   NAMA_FILE_BAPK			VARCHAR(64),
   FILE_BAPK				LONG VARGRAPHIC,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK),
   constraint F_PPMPKPI_PPMBAPK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPMBAPK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_DETAIL_BAPK
--==============================================================
create table PAS_PP_DETAIL_BAPK
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_BAPK				VARCHAR(32)            not null,
   KODE_TANYA_JAWAB			BIGINT                 not null
					generated always as identity,
   PERTANYAAN				VARCHAR(1024)          not null,
   JAWABAN				VARCHAR(8192),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK, KODE_TANYA_JAWAB),
   constraint F_PPMBAPK_PPDBAPK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK)
         references PAS_PP_MASTER_BAPK (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK)
         on delete restrict on update restrict,
   constraint F_EAU_PPDBAPK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_BUKTI_JAWABAN_BAPK
--==============================================================
create table PAS_PP_BUKTI_JAWABAN_BAPK
(
   KODE_BUKTI_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_BAPK				VARCHAR(32)            not null,
   KODE_TANYA_JAWAB			BIGINT                 not null,
   KODE_BUKTI_JAWABAN			BIGINT                 not null
					generated always as identity,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_BUKTI_PEMERIKSAAN_PKPI, KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK, KODE_TANYA_JAWAB, KODE_BUKTI_JAWABAN),
   constraint F_PPDBAPK_PPBJBAPK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK, KODE_TANYA_JAWAB)
         references PAS_PP_DETAIL_BAPK (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK, KODE_TANYA_JAWAB)
         on delete restrict on update restrict,
   constraint F_PPBP_PPBJBAPK foreign key (KODE_BUKTI_PEMERIKSAAN_PKPI)
         references PAS_PP_BUKTI_PEMERIKSAAN_PKPI (KODE_BUKTI_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPBJBAPK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_DOK_ADMINISTRASI_PKPI
--==============================================================
create table PAS_PP_DOK_ADMINISTRASI_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_DOK_ADMINISTRASI_PKPI		BIGINT                 not null
					generated always as identity,
   NAMA_DOK_ADMINISTRASI_PKPI		VARCHAR(64)            not null,
   NOMOR_DOK_ADMINISTRASI_PKPI		VARCHAR(32),
   TANGGAL_DOK_ADMINISTRASI_PKPI	DATE,
   KETERANGAN_DOK_ADMINISTRASI_PK	VARCHAR(256),
   NAMA_FILE_DOK_ADMINISTRASI_PKP	VARCHAR(64)            not null,
   FILE_DOK_ADMINISTRASI_PKPI		LONG VARGRAPHIC        not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_DOK_ADMINISTRASI_PKPI),
   constraint F_PPPKPI_PPDAPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPDAPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_FORMASI_AUDITAN_PKPI
--==============================================================
create table PAS_PP_FORMASI_AUDITAN_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_FORMASI_AUDITAN_PKPI		BIGINT                 not null
					generated always as identity,
   NAMA					VARCHAR(64)            not null,
   NIK					VARCHAR(8)             not null,
   GRADE				SMALLINT               not null,
   JABATAN				VARCHAR(64)            not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_FORMASI_AUDITAN_PKPI),
   constraint F_PPMPKPI_PPFAPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPFAPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_KEUANGAN_AUDITAN_PKPI
--==============================================================
create table PAS_PP_KEUANGAN_AUDITAN_PKPI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_KEUANGAN_AUDITAN_PKPI		BIGINT                 not null
					generated always as identity,
   NAMA_PROFIL_KEUANGAN			VARCHAR(64)            not null,
   NOMINAL_PROFIL_KEUANGAN		BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_KEUANGAN_AUDITAN_PKPI),
   constraint F_PPMPKPI_PPKAPKPI foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         references PAS_PP_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPKAPKPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_PEMERIKSA
--==============================================================
create table PAS_PP_PEMERIKSA
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_USER_PEMERIKSA			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_USER_PEMERIKSA),
   constraint F_PPAPPKPI_PPRPP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         references PAS_PP_ASPEK_PEMERIKSAAN_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPPEMERIKSA_PEMERIKSA foreign key (KODE_USER_PEMERIKSA)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPEMERIKSA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_PEMINTA_KETERANGAN_BAPK
--==============================================================
create table PAS_PP_PEMINTA_KETERANGAN_BAPK
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_BAPK				VARCHAR(32)            not null,
   KODE_USER_PEMINTA_KETERANGAN		BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK, KODE_USER_PEMINTA_KETERANGAN),
   constraint F_PPMBAPK_PPPKBAPK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK)
         references PAS_PP_MASTER_BAPK (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_BAPK)
         on delete restrict on update restrict,
   constraint F_EAU_PPPKBAPK_PK foreign key (KODE_USER_PEMINTA_KETERANGAN)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPPKBAPK foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_PP_PEREVIU
--==============================================================
create table PAS_PP_PEREVIU
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPI		BIGINT                 not null,
   KODE_USER_PEREVIU			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI, KODE_USER_PEREVIU),
   constraint F_PPAPPKPI_PPRRP foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         references PAS_PP_ASPEK_PEMERIKSAAN_PKPI (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, KODE_ASPEK_PEMERIKSAAN_PKPI)
         on delete restrict on update restrict,
   constraint F_EAU_PPPEREVIU foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_KEGIATAN_PKPT
--==============================================================
create table PAS_RA_KEGIATAN_PKPT
(
   KODE_PKPT				BIGINT                 not null,
   KODE_KEGIATAN_PKPT			BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL				DATE                   not null,
   TANGGAL_AKHIR			DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null
					constraint C_NAMA_KEGIATAN check (NAMA_KEGIATAN in ('AM','AP','AI','AT','TI')),
   KETERANGAN_KEGIATAN			VARCHAR(256)          
					constraint C_KETERANGAN_KEGIA check (KETERANGAN_KEGIATAN is null or (KETERANGAN_KEGIATAN in ('PP','IN','PJ'))),
   STATUS_INAP				CHAR(2)                not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null
					constraint C_JENIS_TRANSPORTA check (JENIS_TRANSPORTASI in ('MD','KU')),
   BIAYA_TRANSPORTASI			BIGINT                 not null
					constraint C_BIAYA_TRANSPORTA check (BIAYA_TRANSPORTASI >= 0),
   BIAYA_MOBIL_DINAS			BIGINT                 not null
					constraint C_BIAYA_MOBIL_DINA check (BIAYA_MOBIL_DINAS >= 0),
   BIAYA_LUMPSUM			BIGINT                 not null
					constraint C_BIAYA_LUMPSUM check (BIAYA_LUMPSUM >= 0),
   KODE_USER_PEMBUAT			BIGINT,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_KEGIATAN_PKPT),
   constraint F_RAPKPT_RAKPKPT foreign key (KODE_PKPT)
         references PAS_RA_PKPT (KODE_PKPT)
         on delete restrict on update restrict,
   constraint F_EAU_RAKPKPT_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAKPKPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_AUDITAN_PKPT
--==============================================================
create table PAS_RA_AUDITAN_PKPT
(
   KODE_PKPT				BIGINT                 not null,
   KODE_KEGIATAN_PKPT			BIGINT                 not null,
   KODE_AUDITAN_PKPT			BIGINT                 not null,
   JENIS_AUDIT				CHAR(2)                not null,
   JARAK_AUDITAN			BIGINT                 not null,
   KODE_USER_KOODRINATOR_AUDITOR	BIGINT,
   KODE_USER_KETUA_AUDITOR		BIGINT                 not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_KEGIATAN_PKPT, KODE_AUDITAN_PKPT),
   constraint F_RAKPKPT_RAAPKPT foreign key (KODE_PKPT, KODE_KEGIATAN_PKPT)
         references PAS_RA_KEGIATAN_PKPT (KODE_PKPT, KODE_KEGIATAN_PKPT)
         on delete restrict on update restrict,
   constraint F_EAU_RAAPKPT_KETUA foreign key (KODE_USER_KETUA_AUDITOR)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_PPAPKPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_ANGGOTA_AUDITOR_PKPT
--==============================================================
create table PAS_RA_ANGGOTA_AUDITOR_PKPT
(
   KODE_PKPT				BIGINT                 not null,
   KODE_KEGIATAN_PKPT			BIGINT                 not null,
   KODE_AUDITAN_PKPT			BIGINT                 not null,
   KODE_USER_ANGGOTA_AUDITOR_PKPT	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_KEGIATAN_PKPT, KODE_AUDITAN_PKPT, KODE_USER_ANGGOTA_AUDITOR_PKPT),
   constraint F_RAAPKPT_RAAAPKPT foreign key (KODE_PKPT, KODE_KEGIATAN_PKPT, KODE_AUDITAN_PKPT)
         references PAS_RA_AUDITAN_PKPT (KODE_PKPT, KODE_KEGIATAN_PKPT, KODE_AUDITAN_PKPT)
         on delete restrict on update restrict,
   constraint F_EAU_RAAAPKPT_AGGTA foreign key (KODE_USER_ANGGOTA_AUDITOR_PKPT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_RAAAPKPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_KEGIATAN_RKBPT
--==============================================================
create table PAS_RA_KEGIATAN_RKBPT
(
   KODE_RKBPT				BIGINT                 not null,
   KODE_KEGIATAN_RKBPT			BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL				DATE                   not null,
   TANGGAL_AKHIR			DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null,
   KETERANGAN_KEGIATAN			VARCHAR(256),
   TEMPAT_KEGIATAN			VARCHAR(256)           not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   STATUS_INAP				CHAR(2)                not null,
   JARAK				BIGINT                 not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null,
   BIAYA_TRANSPORTASI			BIGINT                 not null,
   BIAYA_LUMPSUM			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_IDENTIFIER_1 primary key (KODE_RKBPT, KODE_KEGIATAN_RKBPT),
   constraint F_RAMRKBPT_RAKRKBP foreign key (KODE_RKBPT)
         references PAS_RA_RKBPT (KODE_RKBPT)
         on delete restrict on update restrict,
   constraint F_EAU_RAKRKBPT foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_MARA
--==============================================================
create table PAS_RA_MARA
(
   KODE_PKPT				BIGINT                 not null,
   KODE_MARA				BIGINT                 not null,
   KODE_BOBOT_RI_PI			BIGINT,
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_KEY_1 primary key (KODE_PKPT, KODE_MARA),
   constraint F_REFERENCE_69 foreign key (KODE_PKPT)
         references PAS_RA_PKPT (KODE_PKPT)
         on delete restrict on update restrict,
   constraint F_KSBRIPI_RAMARA foreign key (KODE_BOBOT_RI_PI)
         references PAS_KS_BOBOT_RI_PI (KODE_BOBOT_RI_PI)
         on delete restrict on update restrict,
   constraint F_EAU_RAMARA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_MARA_PI
--==============================================================
create table PAS_RA_MARA_PI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_MARA				BIGINT                 not null,
   KODE_MARA_PI				BIGINT                 not null
					generated always as identity,
   KODE_AUDITAN_MARA_PI			BIGINT,
   KODE_PARAMETER_MARA_PI		BIGINT                 not null,
   NILAI_PI_AUDITAN			SMALLINT               not null
					constraint C_NILAI_PI_AUDITAN check (NILAI_PI_AUDITAN between 0 and 100),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_MARA, KODE_MARA_PI),
   constraint F_KSPMARAPI_RAMARA foreign key (KODE_PARAMETER_MARA_PI)
         references PAS_KS_PARAMETER_MARA_PI (KODE_PARAMETER_MARA_PI)
         on delete restrict on update restrict,
   constraint F_RAMARA_RAMARAPI foreign key (KODE_PKPT, KODE_MARA)
         references PAS_RA_MARA (KODE_PKPT, KODE_MARA)
         on delete restrict on update restrict,
   constraint F_EAA_RAMARAPI foreign key (KODE_AUDITAN_MARA_PI)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_RAMARAPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_RA_MARA_RI
--==============================================================
create table PAS_RA_MARA_RI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_MARA				BIGINT                 not null,
   KODE_MARA_RI				BIGINT                 not null
					generated always as identity,
   KODE_AUDITAN_MARA_RI			BIGINT,
   KODE_PARAMETER_MARA_RI		BIGINT                 not null,
   NILAI_RI_AUDITAN			SMALLINT               not null
					constraint C_NILAI_RI_AUDITAN check (NILAI_RI_AUDITAN between 0 and 100),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_MARA, KODE_MARA_RI),
   constraint F_KSPMARARI_RAMARA foreign key (KODE_PARAMETER_MARA_RI)
         references PAS_KS_PARAMETER_MARA_RI (KODE_PARAMETER_MARA_RI)
         on delete restrict on update restrict,
   constraint F_RAMARA_RAMARARI foreign key (KODE_PKPT, KODE_MARA)
         references PAS_RA_MARA (KODE_PKPT, KODE_MARA)
         on delete restrict on update restrict,
   constraint F_EAA_RAMARARI foreign key (KODE_AUDITAN_MARA_RI)
         references PAS_EA_AUDITAN (KODE_AUDITAN)
         on delete restrict on update restrict,
   constraint F_EAU_RAMARARI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_KEGIATAN_PKPB
--==============================================================
create table PAS_SA_KEGIATAN_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL				DATE                   not null,
   TANGGAL_AKHIR			DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null,
   KETERANGAN_KEGIATAN			VARCHAR(256),
   STATUS_INAP				CHAR(2)                not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null,
   BIAYA_TRANSPORTASI			BIGINT                 not null,
   BIAYA_MOBIL_DINAS			BIGINT                 not null,
   BIAYA_LUMPSUM			BIGINT                 not null,
   KODE_USER_PEMBUAT			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB),
   constraint F_SAMPKPB_SAAPKPB foreign key (KODE_PKPT, KODE_PKPB)
         references PAS_SA_PKPB (KODE_PKPT, KODE_PKPB)
         on delete restrict on update restrict,
   constraint F_EAU_SAKPKPB_BUAT foreign key (KODE_USER_PEMBUAT)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAKPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_AUDITAN_PKPB
--==============================================================
create table PAS_SA_AUDITAN_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   JENIS_AUDIT				CHAR(2)                not null,
   JARAK_AUDITAN			BIGINT                 not null,
   KODE_USER_KOORDINATOR_AUDITOR	BIGINT,
   KODE_USER_KETUA_AUDITOR		BIGINT                 not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB),
   constraint F_SAKPKPB_SAPKPB foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB)
         references PAS_SA_KEGIATAN_PKPB (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB)
         on delete restrict on update restrict,
   constraint F_EAJP_SAAPKPB foreign key (JENIS_AUDIT)
         references PAS_EA_JENIS_PEMERIKSAAN (KODE_JENIS_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPKPB_KOORD foreign key (KODE_USER_KOORDINATOR_AUDITOR)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPKPB_KETUA foreign key (KODE_USER_KETUA_AUDITOR)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_MIRA
--==============================================================
create table PAS_SA_MIRA
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   KODE_MIRA				BIGINT                 not null
					generated always as identity,
   KODE_BOBOT_RI_PI			BIGINT,
   BOBOT_RISIKO_INHEREN			DECIMAL(5,2),
   BOBOT_RISIKO_PENGENDALIAN		DECIMAL(5,2),
   WAKTU_UPDATE				TIMESTAMP,
   USER_UPDATE				BIGINT,
   constraint P_KEY_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA),
   constraint F_SAPKPB_SAMIRA foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         references PAS_SA_AUDITAN_PKPB (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         on delete restrict on update restrict,
   constraint F_KSBRIPI_SAMIRA foreign key (KODE_BOBOT_RI_PI)
         references PAS_KS_BOBOT_RI_PI (KODE_BOBOT_RI_PI)
         on delete restrict on update restrict,
   constraint F_EAU_SAMIRA foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_MIRA_PI
--==============================================================
create table PAS_SA_MIRA_PI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   KODE_MIRA				BIGINT                 not null,
   KODE_MIRA_PI				BIGINT                 not null
					generated always as identity,
   KODE_ASPEK_AUDIT_MIRA_PI		VARCHAR(8)             not null,
   KODE_PARAMETER_MIRA_PI		BIGINT,
   NILAI_PI_ASPEK_AUDIT			SMALLINT               not null
					constraint C_NILAI_PI_ASPEK_A check (NILAI_PI_ASPEK_AUDIT between 0 and 100),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA, KODE_MIRA_PI),
   constraint F_SAMIRA_SAMIRAPI foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA)
         references PAS_SA_MIRA (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA)
         on delete restrict on update restrict,
   constraint F_EAAP_SAMIRAPI foreign key (KODE_ASPEK_AUDIT_MIRA_PI)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_KSPMIRAPI_SAMIRAPI foreign key (KODE_PARAMETER_MIRA_PI)
         references PAS_KS_PARAMETER_MIRA_PI (KODE_PARAMETER_MIRA_PI)
         on delete restrict on update restrict,
   constraint F_EAU_RAMIRAPI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_MIRA_RI
--==============================================================
create table PAS_SA_MIRA_RI
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   KODE_MIRA				BIGINT                 not null,
   KODE_MIRA_RI				BIGINT                 not null
					generated always as identity,
   KODE_ASPEK_AUDIT_MIRA_RI		VARCHAR(8)             not null,
   KODE_PARAMETER_MIRA_RI		BIGINT,
   NILAI_RI_ASPEK_AUDIT			SMALLINT               not null
					constraint C_NILAI_RI_ASPEK_A check (NILAI_RI_ASPEK_AUDIT between 0 and 100),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA, KODE_MIRA_RI),
   constraint F_SAMIRA_SAMIRARI foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA)
         references PAS_SA_MIRA (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_MIRA)
         on delete restrict on update restrict,
   constraint F_EAAP_SAMIRARI foreign key (KODE_ASPEK_AUDIT_MIRA_RI)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_KSPMIRARI_SAMIRARI foreign key (KODE_PARAMETER_MIRA_RI)
         references PAS_KS_PARAMETER_MIRA_RI (KODE_PARAMETER_MIRA_RI)
         on delete restrict on update restrict,
   constraint F_EAU_RAMIRARI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_ANGGOTA_AUDITOR_PKPB
--==============================================================
create table PAS_SA_ANGGOTA_AUDITOR_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   KODE_USER_ANGGOTA_AUDITOR_PKPB	BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_USER_ANGGOTA_AUDITOR_PKPB),
   constraint F_SAAPKPB_SAAAPKPB foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         references PAS_SA_AUDITAN_PKPB (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         on delete restrict on update restrict,
   constraint F_EAU_SAAAPKPB_AGGTA foreign key (KODE_USER_ANGGOTA_AUDITOR_PKPB)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_ASPEK_PEMERIKSAAN_PKPB
--==============================================================
create table PAS_SA_ASPEK_PEMERIKSAAN_PKPB
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_KEGIATAN_PKPB			BIGINT                 not null,
   KODE_AUDITAN_PKPB			BIGINT                 not null,
   KODE_ASPEK_PEMERIKSAAN_PKPB		VARCHAR(8)             not null,
   KODE_USER_PEMERIKSA			BIGINT                 not null,
   KODE_USER_PEREVIU			BIGINT                 not null,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB, KODE_ASPEK_PEMERIKSAAN_PKPB),
   constraint F_SAAPKPB_SAAPPKPB foreign key (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         references PAS_SA_AUDITAN_PKPB (KODE_PKPT, KODE_PKPB, KODE_KEGIATAN_PKPB, KODE_AUDITAN_PKPB)
         on delete restrict on update restrict,
   constraint F_EAAP_SAAPPKPB foreign key (KODE_ASPEK_PEMERIKSAAN_PKPB)
         references PAS_EA_ASPEK_PEMERIKSAAN (KODE_ASPEK_PEMERIKSAAN)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPPKPB_PEMERIKSA foreign key (KODE_USER_PEMERIKSA)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPPKPB_PEREVIU foreign key (KODE_USER_PEREVIU)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_SAAPPKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_SA_KEGIATAN_RKPB
--==============================================================
create table PAS_SA_KEGIATAN_RKPB
(
   KODE_RKBPT				BIGINT                 not null,
   KODE_RKPB				BIGINT                 not null,
   KODE_KEGIATAN_RKPB			BIGINT                 not null
					generated always as identity,
   TANGGAL_AWAL				DATE                   not null,
   TANGGAL_AKHIR			DATE                   not null,
   NAMA_KEGIATAN			VARCHAR(256)           not null,
   KETERANGAN_KEGIATAN			VARCHAR(256)           not null
					constraint C_KETERANGAN_KEGIA check (KETERANGAN_KEGIATAN in ('PP','IN','PJ')),
   TEMPAT_KEGIATAN			VARCHAR(256)           not null,
   JUMLAH_PERSONIL			SMALLINT               not null,
   JARAK				BIGINT                 not null,
   JENIS_TRANSPORTASI			CHAR(2)                not null
					constraint C_JENIS_TRANSPORTA check (JENIS_TRANSPORTASI in ('MD','KU')),
   BIAYA_TRANSPORTASI			BIGINT                 not null
					constraint C_BIAYA_TRANSPORTA check (BIAYA_TRANSPORTASI >= 0),
   BIAYA_LUMPSUM			BIGINT                 not null
					constraint C_BIAYA_LUMPSUM check (BIAYA_LUMPSUM >= 0),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_RKBPT, KODE_RKPB, KODE_KEGIATAN_RKPB),
   constraint F_SARKPB_SAKRKPB foreign key (KODE_RKBPT, KODE_RKPB)
         references PAS_SA_RKPB (KODE_RKBPT, KODE_RKPB)
         on delete restrict on update restrict,
   constraint F_EAU_SAKRKPB foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_TL_TL_TEMUAN_AUDIT_EKSTERN
--==============================================================
create table PAS_TL_TL_TEMUAN_AUDIT_EKSTERN
(
   KODE_AUDITOR_EKSTERN			BIGINT                 not null,
   NOMOR_LHA_EKSTERN			VARCHAR(64)            not null,
   KODE_TEMUAN_AUDIT_EKSTERN		BIGINT                 not null,
   KODE_TL_TEMUAN_AUDIT_EKSTERN		BIGINT                 not null
					generated always as identity,
   TINDAK_LANJUT			VARCHAR(8192)          not null,
   WAKTU_TINDAK_LANJUT			DATE                   not null,
   KODE_USER_INPUT_TL			BIGINT                 not null,
   TIPE_USER_INPUT_TL			CHAR(2)                not null
					constraint C_TIPE_USER_INP_TL check (TIPE_USER_INPUT_TL in ('AN','AR')),
   TL_UNTUK_AUDITOR_EKSTERN		VARCHAR(8192),
   TANGGAPAN_AUDITOR			VARCHAR(1024),
   WAKTU_TANGGAPAN			DATE,
   KODE_USER_PEMBERI_TANGGAPAN		BIGINT,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN, KODE_TL_TEMUAN_AUDIT_EKSTERN),
   constraint F_LPTAE_TLTAE foreign key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN)
         references PAS_LP_TEMUAN_AUDIT_EKSTERN (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN)
         on delete restrict on update restrict,
   constraint F_EAU_TLTAE_KUPT foreign key (KODE_USER_PEMBERI_TANGGAPAN)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_TLTAE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_TL_BUKTI_TL_AUDIT_EKSTERN
--==============================================================
create table PAS_TL_BUKTI_TL_AUDIT_EKSTERN
(
   KODE_AUDITOR_EKSTERN			BIGINT                 not null,
   NOMOR_LHA_EKSTERN			VARCHAR(64)            not null,
   KODE_TEMUAN_AUDIT_EKSTERN		BIGINT                 not null,
   KODE_TL_TEMUAN_AUDIT_EKSTERN		BIGINT                 not null,
   KODE_BUKTI_TL_AUDIT_EKSTERN		BIGINT                 not null
					generated always as identity,
   NAMA_FILE_BUKTI_TINDAK_LANJUT	VARCHAR(64)            not null,
   FILE_BUKTI_TINDAK_LANJUT		LONG VARGRAPHIC        not null,
   KETERANGAN_BUKTI_TINDAK_LANJUT	VARCHAR(256),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN, KODE_TL_TEMUAN_AUDIT_EKSTERN, KODE_BUKTI_TL_AUDIT_EKSTERN),
   constraint F_TLTAE_TLBTLAE foreign key (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN, KODE_TL_TEMUAN_AUDIT_EKSTERN)
         references PAS_TL_TL_TEMUAN_AUDIT_EKSTERN (KODE_AUDITOR_EKSTERN, NOMOR_LHA_EKSTERN, KODE_TEMUAN_AUDIT_EKSTERN, KODE_TL_TEMUAN_AUDIT_EKSTERN)
         on delete restrict on update restrict,
   constraint F_EAU_TLBTLAE foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_TL_TL_TEMUAN_AUDIT_INTERN
--==============================================================
create table PAS_TL_TL_TEMUAN_AUDIT_INTERN
(
   KODE_TEMUAN_AUDIT_INTERN		BIGINT                 not null,
   KODE_TL_TEMUAN_AUDIT_INTERN		BIGINT                 not null
					generated always as identity,
   TINDAK_LANJUT			VARCHAR(8192)          not null,
   WAKTU_TINDAK_LANJUT			DATE                   not null,
   KODE_USER_INPUT_TL			BIGINT                 not null,
   TIPE_USER_INPUT_TL			CHAR(2)                not null
					constraint C_TIPE_USER_INP_TL check (TIPE_USER_INPUT_TL in ('AN','AR')),
   TANGGAPAN_AUDITOR			VARCHAR(1024),
   WAKTU_TANGGAPAN			TIMESTAMP,
   KODE_USER_PEMBERI_TANGGAPAN		BIGINT,
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TEMUAN_AUDIT_INTERN, KODE_TL_TEMUAN_AUDIT_INTERN),
   constraint F_LPTAI_TLTAI foreign key (KODE_TEMUAN_AUDIT_INTERN)
         references PAS_LP_TEMUAN_AUDIT_INTERN (KODE_TEMUAN_AUDIT_INTERN)
         on delete restrict on update restrict,
   constraint F_EAU_TLTAI_KUPT foreign key (KODE_USER_PEMBERI_TANGGAPAN)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict,
   constraint F_EAU_TLTLTAI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_TL_BUKTI_TL_AUDIT_INTERN
--==============================================================
create table PAS_TL_BUKTI_TL_AUDIT_INTERN
(
   KODE_TEMUAN_AUDIT_INTERN		BIGINT                 not null,
   KODE_TL_TEMUAN_AUDIT_INTERN		BIGINT                 not null,
   KODE_BUKTI_TL_AUDIT_INTERN		BIGINT                 not null
					generated always as identity,
   NAMA_FILE_BUKTI_TINDAK_LANJUT	VARCHAR(64)            not null,
   FILE_BUKTI_TINDAK_LANJUT		LONG VARGRAPHIC        not null,
   KETERANGAN_BUKTI_TINDAK_LANJUT	VARCHAR(256),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_TEMUAN_AUDIT_INTERN, KODE_TL_TEMUAN_AUDIT_INTERN, KODE_BUKTI_TL_AUDIT_INTERN),
   constraint F_TLTAI_TLBTLAI foreign key (KODE_TEMUAN_AUDIT_INTERN, KODE_TL_TEMUAN_AUDIT_INTERN)
         references PAS_TL_TL_TEMUAN_AUDIT_INTERN (KODE_TEMUAN_AUDIT_INTERN, KODE_TL_TEMUAN_AUDIT_INTERN)
         on delete restrict on update restrict,
   constraint F_EAU_TLBTLAI foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

--==============================================================
-- Table: PAS_TL_TL_KASUS_PELANGGARAN
--==============================================================
create table PAS_TL_TL_KASUS_PELANGGARAN
(
   KODE_PKPT				BIGINT                 not null,
   KODE_PKPB				BIGINT                 not null,
   KODE_REALISASI_KEGIATAN_PKPB		BIGINT                 not null,
   KODE_PKPI				BIGINT                 not null,
   NOMOR_LHPP				VARCHAR(32)            not null,
   NIK_PELAKU				VARCHAR(8)             not null,
   KODE_TINDAK_LANJUT_KASUS		BIGINT                 not null
					generated always as identity,
   TANGGAL_MDW				DATE,
   NOMOR_MDW				VARCHAR(64),
   TANGGAL_MDP				DATE,
   NOMOR_MDP				VARCHAR(64),
   TANGGAL_SK_HUKUMAN			DATE,
   NOMOR_SK_HUKUMAN			VARCHAR(64),
   NAMA_FILE_SK_HUKUMAN			CHAR(64),
   FILE_SK_HUKUMAN			LONG VARGRAPHIC,
   JENIS_HUKUMAN			CHAR(3),
   TANGGAL_SK_TGR			DATE,
   NOMOR_SK_TGR				VARCHAR(64),
   NAMA_FILE_SK_TGR			VARCHAR(64),
   FILE_SK_TGR				LONG VARGRAPHIC,
   PENYELESAIAN_KERUGIAN		VARCHAR(1024),
   WAKTU_UPDATE				TIMESTAMP              not null,
   USER_UPDATE				BIGINT                 not null,
   constraint P_IDENTIFIER_1 primary key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP, NIK_PELAKU, KODE_TINDAK_LANJUT_KASUS),
   constraint F_LPPP_TLK foreign key (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP, NIK_PELAKU)
         references PAS_LP_PELAKU_PELANGGARAN (KODE_PKPT, KODE_PKPB, KODE_REALISASI_KEGIATAN_PKPB, KODE_PKPI, NOMOR_LHPP, NIK_PELAKU)
         on delete restrict on update restrict,
   constraint F_EAU_TLTLKP foreign key (USER_UPDATE)
         references PAS_EA_USER (KODE_USER)
         on delete restrict on update restrict
);

