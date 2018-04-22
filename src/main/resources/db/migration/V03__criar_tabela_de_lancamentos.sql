create table lancamento (
	codigo serial primary key not null,
	descricao text not null,
	data_pagamento date,
	data_vencimento date not null,
	valor decimal not null,
	observacao text,
	tipo varchar(20),
	codigo_categoria bigint not null,
	codigo_pessoa bigint not null,
	foreign key (codigo_categoria) references categoria(codigo),
	foreign key (codigo_pessoa) references pessoa(codigo)
);

INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste2', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste3', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste4', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('tsefude', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste5', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste6', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste7', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste8', now(), now(), 1500, null, 1, 1, 4);
INSERT INTO public.lancamento( descricao, data_pagamento, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)    VALUES ('teste9', now(), now(), 1500, null, 1, 1, 4);