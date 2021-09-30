<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<table cellpadding="2" cellspacing="2" border="1">
			<tr>
				<th>tárgy</th>
				<th>időpont</th>
				<th>kezdete</th>
				<th>vége</th>
				<th>helyszín</th>
				<th>oktató</th>
				<th>szak</th>
			</tr>
			<xsl:apply-templates select="orarend" />
			<td>
				<p>Készítette: Farkas Ádám</p>
			</td>
		</table>
	</xsl:template>
	
	<xsl:template match="orarend">
		<xsl:apply-templates select="ora"></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="ora">
		<tr>
			<td>
				<xsl:value-of select="targy"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="idopont/@nap"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="idopont/@tol"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="idopont/@ig"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="helyszin"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="oktato"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="szak"></xsl:value-of>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>