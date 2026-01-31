# <center>FontEngine</center>

---
**FontEngine** is a professional PlaceholderAPI expansion for Minecraft servers that allows advanced text formatting with **custom text fonts, number fonts, combined letters + numbers, and multiple color modes** including gradients, solid colors, rainbow effects, and vanilla color codes.

---

## Features

- Transform text with multiple font styles
- Transform numbers with multiple numeric fonts
- Combined text + number formatting
- Gradient color support
- Solid color support
- Rainbow color support
- Vanilla color codes (`&c`, `&a`, etc.)
- Hex color support (`#ff0000`)
- Short aliases for all modes

---

## Placeholder Syntax

### Basic Text/Number

%fontengine_<mode>/<font>/<color>[<color-data>]=(<text>)%


- `<mode>`: `text` or `t`, `number` or `n`
- `<font>`: Font index (see font tables below)
- `<color>`: `gradient` (`g`), `solid` (`s`), `rainbow` (`r`), `none` (`n`)
- `<color-data>`: Hex colors, RGB for rainbow, or Minecraft color codes (`&c`)
- `<text>`: Content with placeholders

---

### Combined Mode

%fontengine_cd<t:<text-font>/n:<number-font>/<color>>=(<text>)%


- Applies a font to letters (`t:<text-font>`) and a font to numbers (`n:<number-font>`)
- Color can be `gradient`, `solid`, `rainbow`, `none`
- Placeholders inside `{}` are parsed automatically

---

## Fonts Index

### Text Fonts (letters only)
| Index | Name |
|-------|------|
| 1 | Small Caps |
| 2 | Bubble |
| 3 | Superscript |
| 4 | Extended Unicode |

### Number Fonts (digits only)
| Index | Name |
|-------|------|
| 1 | Normal |
| 2 | Bold Unicode |
| 3 | Circled |
| 4 | Serif |
| 5 | Superscript |
| 6 | Subscript |


## Color Systems
| Type | Alias | Example |
|------|-------|--------|
| Gradient | `g` | `g[#ff0000:#00ff00]` |
| Solid | `s` | `s[#00ffff]` |
| Rainbow | `r` | `r[255]` |
| Vanilla | `n` | `n[&c]` |
| Hex | `n` | `n[#ff0000]` |

---
# Examples
### Text Mode (letters only)

`%fontengine_text/1/g[#ff0000:#00ff00]=(Hi {player_name})%`

### Number Mode (digits only)

`%fontengine_number/4/s[#00ffff]=({player_ping})%`

### Combined Mode (letters + numbers) Gradient

`%fontengine_cd<t:3/n:2/g[#ff0000:#00ff00]>=({player_uuid})%`

### Combined Mode Rainbow

`%fontengine_cd<t:1/n:2/r:255>=({player_uuid})%`

### Combined Mode Vanilla Color

### `%fontengine_cd<t:2/n:4/n:&c>=({player_uuid})%`

### Combined Mode Hex Color

`%fontengine_cd<t:1/n:3/n:#ff0000>=({player_uuid})%`

---

## Placeholder Support

FontEngine fully supports:

- `{player_name}`, `{server_version}`, etc.


All placeholders are resolved before applying fonts and colors.

---
### <center>Developed by Senkex @ Powered by Nautic Studios</center>