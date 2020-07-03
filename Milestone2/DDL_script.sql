USE [Bookstore]
GO
/****** Object:  Table [dbo].[Addresses]    Script Date: 3/5/2020 9:11:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses]
(
	[AddressID] [int] NOT NULL,
	[HouseNumber] [varchar](20) NOT NULL,
	[Street] [varchar](50) NOT NULL,
	[City] [varchar](100) NOT NULL,
	[StateOrProvince] [varchar](50) NOT NULL,
	[ZipCode] [varchar](12) NOT NULL,
	[Country] [varchar](100) NOT NULL,
	[UserID] [int] NOT NULL
		CONSTRAINT [PK_Addresses] PRIMARY KEY CLUSTERED
(
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 3/5/2020 9:11:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users]
(
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](50) NOT NULL,
	[MiddleInitial] [char](2) NOT NULL,
	[LastName] [varchar](50) NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Addresses] WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
